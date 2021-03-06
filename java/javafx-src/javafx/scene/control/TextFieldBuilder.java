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
Builder class for javafx.scene.control.TextField
@see javafx.scene.control.TextField
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class TextFieldBuilder<B extends javafx.scene.control.TextFieldBuilder<B>> extends javafx.scene.control.TextInputControlBuilder<B> implements javafx.util.Builder<javafx.scene.control.TextField> {
    protected TextFieldBuilder() {
    }
    
    /** Creates a new instance of TextFieldBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.control.TextFieldBuilder<?> create() {
        return new javafx.scene.control.TextFieldBuilder();
    }
    
    private int __set;
    public void applyTo(javafx.scene.control.TextField x) {
        super.applyTo(x);
        int set = __set;
        if ((set & (1 << 0)) != 0) x.setAlignment(this.alignment);
        if ((set & (1 << 1)) != 0) x.setOnAction(this.onAction);
        if ((set & (1 << 2)) != 0) x.setPrefColumnCount(this.prefColumnCount);
        if ((set & (1 << 3)) != 0) x.setPromptText(this.promptText);
    }
    
    private javafx.geometry.Pos alignment;
    /**
    Set the value of the {@link javafx.scene.control.TextField#getAlignment() alignment} property for the instance constructed by this builder.
    * @since JavaFX 2.1
    */
    @SuppressWarnings("unchecked")
    public B alignment(javafx.geometry.Pos x) {
        this.alignment = x;
        __set |= 1 << 0;
        return (B) this;
    }
    
    private javafx.event.EventHandler<javafx.event.ActionEvent> onAction;
    /**
    Set the value of the {@link javafx.scene.control.TextField#getOnAction() onAction} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B onAction(javafx.event.EventHandler<javafx.event.ActionEvent> x) {
        this.onAction = x;
        __set |= 1 << 1;
        return (B) this;
    }
    
    private int prefColumnCount;
    /**
    Set the value of the {@link javafx.scene.control.TextField#getPrefColumnCount() prefColumnCount} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B prefColumnCount(int x) {
        this.prefColumnCount = x;
        __set |= 1 << 2;
        return (B) this;
    }
    
    private java.lang.String promptText;
    /**
    Set the value of the {@link javafx.scene.control.TextField#getPromptText() promptText} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B promptText(java.lang.String x) {
        this.promptText = x;
        __set |= 1 << 3;
        return (B) this;
    }
    
    /**
    Make an instance of {@link javafx.scene.control.TextField} based on the properties set on this builder.
    */
    public javafx.scene.control.TextField build() {
        javafx.scene.control.TextField x = new javafx.scene.control.TextField();
        applyTo(x);
        return x;
    }
}
