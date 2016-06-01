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

package com.sun.media.jfxmediaimpl.platform.ios;

import com.sun.media.jfxmedia.Media;
import com.sun.media.jfxmedia.MediaPlayer;
import com.sun.media.jfxmedia.locator.Locator;
import com.sun.media.jfxmedia.logging.Logger;
import com.sun.media.jfxmediaimpl.HostUtils;
import com.sun.media.jfxmediaimpl.platform.Platform;
import java.util.Arrays;

/**
 * iOS Platform implementation.
 */
public final class IOSPlatform extends Platform {

    /**
     * The MIME types of all supported media.
     */
    private static final String[] CONTENT_TYPES = {
        "video/mp4",
        "audio/x-m4a",
        "video/x-m4v",
        "application/vnd.apple.mpegurl",
        "audio/mpegurl",
        "audio/mpeg",
        "audio/mp3",
        "audio/x-wav",
        "video/quicktime",
        "video/x-quicktime",
        "audio/x-aiff"
    };
    
    /**
     * All supported protocols.
     */
    private static final String[] PROTOCOLS = {
        "http",
        "https",
        "ipod-library"
    };

    private static final class IOSPlatformInitializer {
        private static final IOSPlatform globalInstance = new IOSPlatform();
    }

    public static Platform getPlatformInstance() {
        return IOSPlatformInitializer.globalInstance;
    }

    private IOSPlatform() {
    }

    /**
     * @return false if the platform cannot be loaded
     */
    @Override
    public boolean loadPlatform() {
        if (!HostUtils.isIOS()) {
            return false;
        }

        try {
            iosPlatformInit();
        } catch (UnsatisfiedLinkError ule) {
            if (Logger.canLog(Logger.DEBUG)) {
                Logger.logMsg(Logger.DEBUG, "Unable to load iOS platform.");
            }
            //MediaUtils.nativeError(IOSPlatform.class, MediaError.ERROR_MANAGER_ENGINEINIT_FAIL);
            return false;
        }
        return true;
    }

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
        return new IOSMedia(source);
    }

    @Override
    public MediaPlayer createMediaPlayer(Locator source) {
        try {
            return new IOSMediaPlayer(source);
        } catch (Exception e) {
            if (Logger.canLog(Logger.DEBUG)) {
                Logger.logMsg(Logger.DEBUG, "IOSPlatform caught exception while creating media player: "+e);
            }
        }
        return null;
    }

    private static native void iosPlatformInit();
}