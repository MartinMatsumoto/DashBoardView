package com.example.martin.dashboardview.property.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;

public class OvalIndicator extends BaseIndicator {

    /**
     * 起始角度
     */
    private int startArc;

    /**
     * 结束角度
     */
    private int endArc;

    /**
     * 半径
     */
    private int radius;

    /**
     * 颜色
     */
    private int color;

    /**
     * 透明度
     */
    private int alpha;

    /**
     * 线宽
     */
    private int strokeWidth;

    /**
     * 个数
     */
    private int count;

    /**
     * 线帽
     * ROUND / SQUARE
     */
    private Paint.Cap paintCap = Paint.Cap.SQUARE;

    public int getStartArc() {
        return startArc;
    }

    public void setStartArc(int startArc) {
        this.startArc = startArc;
    }

    public int getEndArc() {
        return endArc;
    }

    public void setEndArc(int endArc) {
        this.endArc = endArc;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public Paint.Cap getPaintCap() {
        return paintCap;
    }

    public void setPaintCap(Paint.Cap paintCap) {
        this.paintCap = paintCap;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void draw(Canvas canvas, Paint paint, int sideLength) {
        sideLength = sideLength / 2;
        canvas.save();
        paint.setShader(null);
        paint.setColor(color);
        paint.setStrokeCap(paintCap);
        paint.setStrokeWidth(strokeWidth);
        paint.setStyle(Paint.Style.FILL);

        float degree = (endArc - startArc) * 1.0f / count * 1.0f;
        float degreeTotal = 0f;

//        canvas.rotate(-degree, sideLength, sideLength);

        canvas.drawCircle(sideLength, sideLength - radius, 20, paint);
        // 顺时针旋转
        for (int i = 0; i < count ; i++) {
            canvas.rotate(degree, sideLength, sideLength);
            canvas.drawCircle(sideLength, sideLength - radius, 20, paint);
            degreeTotal += degree;
        }
        //指示的圆点要大些 除了100%
        /*if (mCreditValueSolid != mMax) {
            canvas.drawCircle(mCenterX, mPadding + mLength1, mProgressWidth + 5, mPaint);
        }*/

        canvas.restore();
    }
}
