package com.example.martin.dashboardview.property.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class RectIndicator extends BaseIndicator {

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
     * 宽
     */
    private int width;

    /**
     * 高
     */
    private int height;

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

    /**
     * 半径
     */
    private int circleRadius;

    /**
     * 半径
     */
    private int circleRadiusOffset;

    /**
     * 方块类型
     */
    private int rectType = RECT;

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

    public int getRectType() {
        return rectType;
    }

    public void setRectType(int rectType) {
        this.rectType = rectType;
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

    @Override
    public void draw(Canvas canvas, Paint paint, int sideLength) {
        sideLength = sideLength / 2;
        canvas.save();
        paint.setShader(null);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);

        float degree = (endArc - startArc) * 1.0f / count * 1.0f;
        int currOffsetCount = 0;

        // 顺时针旋转
        for (int i = 0; i < count; i++) {
            canvas.rotate(degree, sideLength, sideLength);
            if (currOffsetCount == offSetCount) {
                paint.setColor(colorOffset);
                paint.setStrokeWidth(strokeWidthOffset);
                currOffsetCount = 0;
            } else {
                paint.setColor(color);
                paint.setStrokeWidth(strokeWidth);
                currOffsetCount++;
            }

            RectF rectF = new RectF();
            rectF.set(
                    sideLength - width / 2,
                    sideLength - height / 2 - radius,
                    sideLength + width / 2,
                    sideLength + height / 2 - radius
            );
            if (rectType == RECT) {
                canvas.drawRect(rectF, paint);
            } else if (rectType == ROUND_RECT) {
                canvas.drawRoundRect(rectF, circleRadius, circleRadius, paint);
            } else if (rectType == OVAL) {
                canvas.drawOval(rectF, paint);
            }
        }
        //指示的圆点要大些 除了100%
        /*if (mCreditValueSolid != mMax) {
            canvas.drawCircle(mCenterX, mPadding + mLength1, mProgressWidth + 5, mPaint);
        }*/

        canvas.restore();
    }

}
