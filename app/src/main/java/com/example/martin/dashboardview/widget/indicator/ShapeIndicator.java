package com.example.martin.dashboardview.widget.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.martin.dashboardview.property.Property;

public class ShapeIndicator extends BaseIndicator {

    private Property property;

    private Property[] properties;

    @Override
    public void draw(Canvas canvas, Paint paint, int sideLength) {

    }

    public Property[] getProperties() {
        return properties;
    }

    public void setProperties(Property... properties) {
        this.properties = properties;
    }

}
