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
     * 图形列表
     */
    private List<Shape> shapes;

    /**
     * 属性
     */
    private Property property;

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    @Override
    public void draw(Canvas canvas, Paint paint, int sideLength, float rotateDegree) {
        //形状没有怎么画
        if (shapes == null || shapes.isEmpty()) {
            throw new IllegalArgumentException("shapes is null");
        }

        int centerPointer = sideLength / 2;
        Path path = new Path();
        //遍历shape
        for (Shape shape : shapes) {
//            canvas.save();
            shape.setPath(canvas, centerPointer, rotateDegree, path);
//            canvas.restore();
        }
        path.setFillType(Path.FillType.WINDING);
        canvas.drawPath(path, paint);

    }

    public void addShape(Shape shape) {
        if (shapes == null || shapes.isEmpty()) {
            shapes = new ArrayList<>();
        }
        shapes.add(shape);
    }
}
