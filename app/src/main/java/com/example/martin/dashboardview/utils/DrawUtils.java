package com.example.martin.dashboardview.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

import com.example.martin.dashboardview.property.Property;
import com.example.martin.dashboardview.property.Shape;

public class DrawUtils {

    public static void drawRectangle(Canvas canvas, Paint paint, int centerPointer, float rotateDegree, Property property) {
        if (property == null) {
            throw new IllegalArgumentException("property is null");
        }
        property.setPaint(paint);
        canvas.rotate(rotateDegree, centerPointer, centerPointer);
        //判断类型
        if (Shape.RECTANGLE.equals(property.getShape())) {
            RectF rectF = new RectF();
            rectF.set(
                    centerPointer - property.getWidth() / 2,
                    centerPointer - property.getHeight(),
                    centerPointer + property.getWidth() / 2,
                    centerPointer + property.getOffsetX()
            );
            if (property.getAngleRadius() == 0) {
                canvas.drawRect(rectF, paint);
            } else {
                canvas.drawRoundRect(rectF, property.getAngleRadius(), property.getAngleRadius(), paint);
            }
        } else if (property.getShape() == Shape.TRIANGLE) {
            Path pathTriangle = new Path();
            pathTriangle.moveTo(centerPointer, centerPointer);
            pathTriangle.rLineTo(property.getWidth() / 2, 0);
            pathTriangle.rLineTo(-property.getWidth() / 2, -property.getHeight());
            pathTriangle.rLineTo(-property.getWidth() / 2, property.getHeight());
            pathTriangle.setFillType(Path.FillType.WINDING);
            pathTriangle.close();
            canvas.drawPath(pathTriangle, paint);
        } else if (property.getShape() == Shape.CIRCULAR) {
            RectF rectF = new RectF();
            rectF.set(
                    centerPointer - property.getWidth() / 2,
                    centerPointer - property.getHeight(),
                    centerPointer + property.getWidth() / 2,
                    centerPointer + property.getOffsetX()
            );
            canvas.drawOval(rectF, paint);
        } else if (property.getShape() == Shape.ECHELON) {
            Path path = new Path();
            path.moveTo(centerPointer, centerPointer);
            path.rLineTo(property.getWidth() / 2, 0);
            path.rLineTo(-(property.getWidth() - property.getTopWidth()) / 2, -property.getHeight());
            path.rLineTo(-property.getTopWidth(), 0);
            path.rLineTo(-(property.getWidth() - property.getTopWidth()) / 2, property.getHeight());
            path.close();
            canvas.drawPath(path, paint);
        }
    }

    public static void drawShape(Canvas canvas, Paint paint, int centerPointer, float rotateDegree, Property property) {
        //没有属性怎么画
        if (property == null) {
            throw new IllegalArgumentException("property is null");
        }
        property.setPaint(paint);
        canvas.rotate(rotateDegree, centerPointer, centerPointer);
        //判断类型
        if (Shape.RECTANGLE.equals(property.getShape())) {
            RectF rectF = new RectF();
            rectF.set(
                    centerPointer - property.getWidth() / 2,
                    centerPointer - property.getHeight(),
                    centerPointer + property.getWidth() / 2,
                    centerPointer + property.getOffsetX()
            );
            if (property.getAngleRadius() == 0) {
                canvas.drawRect(rectF, paint);
            } else {
                canvas.drawRoundRect(rectF, property.getAngleRadius(), property.getAngleRadius(), paint);
            }
        } else if (property.getShape() == Shape.TRIANGLE) {
            Path pathTriangle = new Path();
            pathTriangle.moveTo(centerPointer, centerPointer);
            pathTriangle.rLineTo(property.getWidth() / 2, 0);
            pathTriangle.rLineTo(-property.getWidth() / 2, -property.getHeight());
            pathTriangle.rLineTo(-property.getWidth() / 2, property.getHeight());
            pathTriangle.setFillType(Path.FillType.WINDING);
            pathTriangle.close();
            canvas.drawPath(pathTriangle, paint);
        } else if (property.getShape() == Shape.CIRCULAR) {
            RectF rectF = new RectF();
            rectF.set(
                    centerPointer - property.getWidth() / 2,
                    centerPointer - property.getHeight(),
                    centerPointer + property.getWidth() / 2,
                    centerPointer + property.getOffsetX()
            );
            canvas.drawOval(rectF, paint);
        } else if (property.getShape() == Shape.ECHELON) {
            Path path = new Path();
            path.moveTo(centerPointer, centerPointer);
            path.rLineTo(property.getWidth() / 2, 0);
            path.rLineTo(-(property.getWidth() - property.getTopWidth()) / 2, -property.getHeight());
            path.rLineTo(-property.getTopWidth(), 0);
            path.rLineTo(-(property.getWidth() - property.getTopWidth()) / 2, property.getHeight());
            path.close();
            canvas.drawPath(path, paint);
        }
    }
}
