/*
 * Copyright (c) 2010, 2015, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.media.jfxmediaimpl.platform.gstreamer;

import com.sun.media.jfxmedia.Media;
import com.sun.media.jfxmedia.MediaError;
import com.sun.media.jfxmedia.MediaPlayer;
import com.sun.media.jfxmedia.events.PlayerStateEvent.PlayerState;
import com.sun.media.jfxmedia.locator.Locator;
import com.sun.media.jfxmedia.logging.Logger;
import com.sun.media.jfxmediaimpl.HostUtils;
import com.sun.media.jfxmediaimpl.MediaUtils;
import com.sun.media.jfxmediaimpl.platform.Platform;
import java.util.Arrays;

/**
 * GStreamer platform implementation.
 */
public final class GSTPlatform extends Platform {
    /**
     * The MIME types of all supported media.
     */
    private static final String[] CONTENT_TYPES = {
        "audio/x-aiff",
        "audio/mp3",
        "audio/mpeg",
        "audio/x-wav",
        "video/x-javafx",
        "video/x-flv",
        "video/x-fxm",
        "video/mp4",
        "audio/x-m4a",
        "video/x-m4v",
        "application/vnd.apple.mpegurl",
        "audio/mpegurl"
    };
    
    /**
     * All supported protocols.
     */
    private static final String[] PROTOCOLS = {
        "file",
        "http",
        "https"
    };

    private static GSTPlatform globalInstance = null;

    @Override
    public boolean loadPlatform() {
        // Initialize GStreamer JNI and supporting native classes.
        MediaError ret;
        try {
            ret = MediaError.getFromCode(gstInitPlatform());
        } catch (UnsatisfiedLinkError ule) {
            ret = MediaError.ERROR_MANAGER_ENGINEINIT_FAIL;
        }
        // Post an error if native initialization fails.
        if (ret != MediaError.ERROR_NONE) {
            MediaUtils.nativeError(GSTPlatform.class, ret);
        }
        return true;
    }

    /*
     * Get an instance of the platform.
     */
    public static synchronized Platform getPlatformInstance() {
        if (null == globalInstance) {
            globalInstance = new GSTPlatform();
        }

        return globalInstance;
    }

    private GSTPlatform() {}

    @Override
    public String[] getSupportedContentTypes() {
        return Arrays.copyOf(CONTENT_TYPES, CONTENT_TYPES.length);
    }
    
    @Override
    public String[] getSupportedProtocols() {
        return Arrays.copyOf(PROTOCOLS, PROTOCOLS.length);
    }

    @Override
    public Media createMedia(Locator source) {
        return new GSTMedia(source);
    }

    @Override
    public MediaPlayer createMediaPlayer(Locator source) {
        GSTMediaPlayer player;
        try {
            player = new GSTMediaPlayer(source);
        } catch (Exception e) {
            if (Logger.canLog(Logger.DEBUG)) {
                Logger.logMsg(Logger.DEBUG, "GSTPlatform caught exception while creating media player: "+e);
            }
            return null;
        }

        // Special case for H.264 decoding on Mac OS X.
        if (HostUtils.isMacOSX()) {
            String contentType = source.getContentType();
            if ("video/mp4".equals(contentType) || "video/x-m4v".equals(contentType)
                  || source.getStringLocation().endsWith(".m3u8"))
            {
                // Block until player transitions to READY or HALTED.

                // Timeouts in milliseconds.
                String scheme = source.getURI().getScheme();
                final long timeout = (scheme.equals("http") || scheme.equals("https")) ?
                        60000L : 5000L;
                final long iterationTime = 50L;
                long timeWaited = 0L;

                final Object lock = new Object();
                PlayerState state = player.getState();

                while (timeWaited < timeout &&
                        (state == PlayerState.UNKNOWN || state == PlayerState.STALLED)) {
                    try {
                        synchronized(lock) {
                            lock.wait(iterationTime);
                            timeWaited += iterationTime;
                        }
                    } catch (InterruptedException ex) {
                        // Ignore it.
                    }

                    state = player.getState();
                }

                // If the player is not READY, an error occurred.
                if (player.getState() != PlayerState.READY) {
                    player.dispose();
                    player = null;
                }
            }
        }
        return player;
    }

    /**
     * Initialize the native peer of this media manager.
     *
     * @return A status code.
     */
    private static native int gstInitPlatform();
}
