package com.example.martin.dashboardview.property;

import android.graphics.Canvas;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

public class Shape {

    /**
     * 矩形
     */
    public static final int RECTANGLE = 1;

    /**
     * 三角形
     */
    public static final int TRIANGLE = 2;

    /**
     * 圆形
     */
    public static final int CIRCULAR = 3;

    /**
     * 梯形
     */
    public static final int ECHELON = 4;

    /**
     * 平行四边形
     */
    public static final int PARALLELOGRAM = 5;

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

    public void setPath(Canvas canvas, int centerPointer, float rotateDegree, Path path) {
        //没有属性怎么画
        if (property == null) {
            throw new IllegalArgumentException("property is null");
        }

//        canvas.rotate(rotateDegree, centerPointer, centerPointer);

        //判断类型
        if (property.getShape() == Shape.RECTANGLE) {
            RectF rectF = new RectF();
            rectF.set(
                    centerPointer - property.getWidth() / 2,
                    centerPointer - property.getHeight(),
                    centerPointer + property.getWidth() / 2,
                    centerPointer + property.getOffsetX()
            );
            if (property.getAngleRadius() == 0) {
                path.addRect(rectF, Path.Direction.CW);
//                canvas.drawRect(rectF, paint);
            } else {
                path.addRoundRect(rectF, property.getAngleRadius(), property.getAngleRadius(), Path.Direction.CW);
//                canvas.drawRoundRect(rectF, property.getAngleRadius(), property.getAngleRadius(), paint);
            }
        } else if (property.getShape() == Shape.TRIANGLE) {
            Path pathTriangle = new Path();
            pathTriangle.moveTo(centerPointer, centerPointer);
            pathTriangle.rLineTo(property.getWidth() / 2, 0);
            pathTriangle.rLineTo(-property.getWidth() / 2, -property.getHeight());
            pathTriangle.rLineTo(-property.getWidth() / 2, property.getHeight());
            pathTriangle.setFillType(Path.FillType.WINDING);
            pathTriangle.close();
            path.addPath(pathTriangle);
//        paint.setPathEffect(new CornerPathEffect(150));
//            paint.setPathEffect(new DiscretePathEffect(10, 10));
        }else if (property.getShape() == Shape.CIRCULAR) {
            RectF rectF = new RectF();
            rectF.set(
                    centerPointer - property.getWidth() / 2,
                    centerPointer - property.getHeight(),
                    centerPointer + property.getWidth() / 2,
                    centerPointer + property.getOffsetX()
            );
            path.addOval(rectF, Path.Direction.CW);
//        paint.setPathEffect(new CornerPathEffect(150));
//            paint.setPathEffect(new DiscretePathEffect(10, 10));
        }

//        canvas.drawPath(path, paint);
    }
}
