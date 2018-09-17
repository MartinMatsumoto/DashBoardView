package com.example.martin.dashboardview.property;

import android.graphics.Canvas;
import android.graphics.Paint;
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

    public static void draw(Canvas canvas, Paint paint, int shape, Property property) {
        if(property == null){

        }

        if(shape == Shape.RECTANGLE){
            int centerPointer = property.getCenterPointer();
            canvas.save();

            paint.setStrokeWidth(property.getStrokeWidth());
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(property.getColor());

            canvas.rotate(property.getRotateDegree(), property.getCenterPointer(), property.getCenterPointer());
            RectF rectF = new RectF();
            rectF.set(
                    sideLength - width / 2,
                    sideLength - height,
                    sideLength + width / 2,
                    sideLength + offset
            );

            if (rectType == RECT) {
                canvas.drawRect(rectF, paint);
            } else if (rectType == ROUND_RECT) {
                canvas.drawRoundRect(rectF, circleRadius, circleRadius, paint);
            } else if (rectType == OVAL) {
                canvas.drawOval(rectF, paint);
            }

            canvas.restore();
        }
    }
}
