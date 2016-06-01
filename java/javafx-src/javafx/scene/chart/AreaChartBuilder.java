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

package javafx.scene.chart;

/**
Builder class for javafx.scene.chart.AreaChart
@see javafx.scene.chart.AreaChart
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class AreaChartBuilder<X, Y, B extends javafx.scene.chart.AreaChartBuilder<X, Y, B>> extends javafx.scene.chart.XYChartBuilder<X, Y, B> {
    protected AreaChartBuilder() {
    }
    
    /** Creates a new instance of AreaChartBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static <X, Y> javafx.scene.chart.AreaChartBuilder<X, Y, ?> create() {
        return new javafx.scene.chart.AreaChartBuilder();
    }
    
    private javafx.scene.chart.Axis<X> XAxis;
    /**
    Set the value of the {@link javafx.scene.chart.AreaChart#getXAxis() XAxis} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B XAxis(javafx.scene.chart.Axis<X> x) {
        this.XAxis = x;
        return (B) this;
    }
    
    private javafx.scene.chart.Axis<Y> YAxis;
    /**
    Set the value of the {@link javafx.scene.chart.AreaChart#getYAxis() YAxis} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B YAxis(javafx.scene.chart.Axis<Y> x) {
        this.YAxis = x;
        return (B) this;
    }
    
    /**
    Make an instance of {@link javafx.scene.chart.AreaChart} based on the properties set on this builder.
    */
    public javafx.scene.chart.AreaChart<X, Y> build() {
        javafx.scene.chart.AreaChart<X, Y> x = new javafx.scene.chart.AreaChart<X, Y>(this.XAxis, this.YAxis);
        applyTo(x);
        return x;
    }
}
