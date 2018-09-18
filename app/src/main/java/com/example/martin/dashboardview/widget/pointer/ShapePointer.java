package com.example.martin.dashboardview.widget.pointer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import com.example.martin.dashboardview.property.Property;
import com.example.martin.dashboardview.property.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * 图形构成的指针
 */
public class ShapePointer extends BasePointer {

    /**
     * 属性
     */
    private Property property;

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    @Override
    public void draw(Canvas canvas, Paint paint, int sideLength, float rotateDegree) {
        int centerPointer = sideLength / 2;
        canvas.save();
//        Shape.draw(canvas, paint, centerPointer, rotateDegree, property);
        canvas.restore();
    }

}
