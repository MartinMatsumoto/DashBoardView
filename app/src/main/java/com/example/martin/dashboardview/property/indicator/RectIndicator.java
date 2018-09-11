package com.example.martin.dashboardview.property.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;

public class RectIndicator extends BaseIndicator {

    /**
     * 起始角度
     */
    private int startArc;

    /**
     * 结束角度
     */
    private int endArc;

    /**
     * 个数
     */
    private int count;

    /**
     * 半径
     */
    private int radius;

    /**
     * 半径
     */
    private int circleRadius;

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
     * 每几个出现偏移量
     */
    private int offSetCount;

    /**
     * 偏移量
     */
    private int offSet;

    /**
     * 半径
     */
    private int circleRadiusOffset;

    /**
     * 颜色
     */
    private int colorOffset;

    /**
     * 透明度
     */
    private int alphaOffset;

    /**
     * 线宽
     */
    private int strokeWidthOffset;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getOffSetCount() {
        return offSetCount;
    }

    public void setOffSetCount(int offSetCount) {
        this.offSetCount = offSetCount;
    }

    public int getOffSet() {
        return offSet;
    }

    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

    public int getCircleRadius() {
        return circleRadius;
    }

    public void setCircleRadius(int circleRadius) {
        this.circleRadius = circleRadius;
    }

    public int getCircleRadiusOffset() {
        return circleRadiusOffset;
    }

    public void setCircleRadiusOffset(int circleRadiusOffset) {
        this.circleRadiusOffset = circleRadiusOffset;
    }

    public int getColorOffset() {
        return colorOffset;
    }

    public void setColorOffset(int colorOffset) {
        this.colorOffset = colorOffset;
    }

    public int getAlphaOffset() {
        return alphaOffset;
    }

    public void setAlphaOffset(int alphaOffset) {
        this.alphaOffset = alphaOffset;
    }

    public int getStrokeWidthOffset() {
        return strokeWidthOffset;
    }

    public void setStrokeWidthOffset(int strokeWidthOffset) {
        this.strokeWidthOffset = strokeWidthOffset;
    }

    @Override
    public void draw(Canvas canvas, Paint paint, int sideLength) {
        sideLength = sideLength / 2;
        canvas.save();
        paint.setShader(null);
        paint.setStyle(Paint.Style.FILL);

        float degree = (endArc - startArc) * 1.0f / count * 1.0f;
        int currOffsetCount = 0;
        // 顺时针旋转
        for (int i = 0; i < count ; i++) {
            float cy = sideLength - radius;
            float radius = circleRadius;
            canvas.rotate(degree, sideLength, sideLength);
            if(currOffsetCount == offSetCount){
                paint.setColor(colorOffset);
                paint.setStrokeWidth(strokeWidthOffset);
                cy += offSet;
                radius = circleRadiusOffset;
                currOffsetCount = 0;
            }else{
                paint.setColor(color);
                paint.setStrokeWidth(strokeWidth);
                currOffsetCount ++;
            }
            canvas.drawCircle(sideLength, cy, radius, paint);
        }
        //指示的圆点要大些 除了100%
        /*if (mCreditValueSolid != mMax) {
            canvas.drawCircle(mCenterX, mPadding + mLength1, mProgressWidth + 5, mPaint);
        }*/

        canvas.restore();
    }

}
