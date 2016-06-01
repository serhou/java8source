/* 
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.control;

/**
Builder class for javafx.scene.control.Accordion
@see javafx.scene.control.Accordion
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class AccordionBuilder<B extends javafx.scene.control.AccordionBuilder<B>> extends javafx.scene.control.ControlBuilder<B> implements javafx.util.Builder<javafx.scene.control.Accordion> {
    protected AccordionBuilder() {
    }
    
    /** Creates a new instance of AccordionBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.control.AccordionBuilder<?> create() {
        return new javafx.scene.control.AccordionBuilder();
    }
    
    private int __set;
    public void applyTo(javafx.scene.control.Accordion x) {
        super.applyTo(x);
        int set = __set;
        if ((set & (1 << 0)) != 0) x.setExpandedPane(this.expandedPane);
        if ((set & (1 << 1)) != 0) x.getPanes().addAll(this.panes);
    }
    
    private javafx.scene.control.TitledPane expandedPane;
    /**
    Set the value of the {@link javafx.scene.control.Accordion#getExpandedPane() expandedPane} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B expandedPane(javafx.scene.control.TitledPane x) {
        this.expandedPane = x;
        __set |= 1 << 0;
        return (B) this;
    }
    
    private java.util.Collection<? extends javafx.scene.control.TitledPane> panes;
    /**
    Add the given items to the List of items in the {@link javafx.scene.control.Accordion#getPanes() panes} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B panes(java.util.Collection<? extends javafx.scene.control.TitledPane> x) {
        this.panes = x;
        __set |= 1 << 1;
        return (B) this;
    }
    
    /**
    Add the given items to the List of items in the {@link javafx.scene.control.Accordion#getPanes() panes} property for the instance constructed by this builder.
    */
    public B panes(javafx.scene.control.TitledPane... x) {
        return panes(java.util.Arrays.asList(x));
    }
    
    /**
    Make an instance of {@link javafx.scene.control.Accordion} based on the properties set on this builder.
    */
    public javafx.scene.control.Accordion build() {
        javafx.scene.control.Accordion x = new javafx.scene.control.Accordion();
        applyTo(x);
        return x;
    }
}