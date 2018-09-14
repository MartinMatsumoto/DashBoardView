package com.example.martin.dashboardview.property.pointer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

public class RectPointer extends BasePointer {

    /**
     * 矩形
     */
    public static final int RECT = 1;
    /**
     * 圆角矩形
     */
    public static final int ROUND_RECT = 2;
    /**
     * 圆形
     */
    public static final int OVAL = 3;

    private int width;

    private int height;

    private int offset;

    private float circleRadius;

    private int color;

    /**
     * 线宽
     */
    private int strokeWidth;
    /**
     * 方块类型
     */
    private int rectType = RECT;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getRectType() {
        return rectType;
    }

    public void setRectType(int rectType) {
        this.rectType = rectType;
    }

    public float getCircleRadius() {
        return circleRadius;
    }

    public void setCircleRadius(float circleRadius) {
        this.circleRadius = circleRadius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    @Override
    public void draw(Canvas canvas, Paint paint, int sideLength, float rotateDegree) {
        sideLength = sideLength / 2;
        canvas.save();

        paint.setStrokeWidth(strokeWidth);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);

        canvas.rotate(rotateDegree, sideLength, sideLength);
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
