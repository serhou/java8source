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

package javafx.scene.shape;

/**
Builder class for javafx.scene.shape.Circle
@see javafx.scene.shape.Circle
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class CircleBuilder<B extends javafx.scene.shape.CircleBuilder<B>> extends javafx.scene.shape.ShapeBuilder<B> implements javafx.util.Builder<javafx.scene.shape.Circle> {
    protected CircleBuilder() {
    }
    
    /** Creates a new instance of CircleBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.shape.CircleBuilder<?> create() {
        return new javafx.scene.shape.CircleBuilder();
    }
    
    private int __set;
    public void applyTo(javafx.scene.shape.Circle x) {
        super.applyTo(x);
        int set = __set;
        if ((set & (1 << 0)) != 0) x.setCenterX(this.centerX);
        if ((set & (1 << 1)) != 0) x.setCenterY(this.centerY);
        if ((set & (1 << 2)) != 0) x.setRadius(this.radius);
    }
    
    private double centerX;
    /**
    Set the value of the {@link javafx.scene.shape.Circle#getCenterX() centerX} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B centerX(double x) {
        this.centerX = x;
        __set |= 1 << 0;
        return (B) this;
    }
    
    private double centerY;
    /**
    Set the value of the {@link javafx.scene.shape.Circle#getCenterY() centerY} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B centerY(double x) {
        this.centerY = x;
        __set |= 1 << 1;
        return (B) this;
    }
    
    private double radius;
    /**
    Set the value of the {@link javafx.scene.shape.Circle#getRadius() radius} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B radius(double x) {
        this.radius = x;
        __set |= 1 << 2;
        return (B) this;
    }
    
    /**
    Make an instance of {@link javafx.scene.shape.Circle} based on the properties set on this builder.
    */
    public javafx.scene.shape.Circle build() {
        javafx.scene.shape.Circle x = new javafx.scene.shape.Circle();
        applyTo(x);
        return x;
    }
}
