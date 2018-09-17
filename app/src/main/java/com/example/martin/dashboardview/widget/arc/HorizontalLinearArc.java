package com.example.martin.dashboardview.widget.arc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;

public class HorizontalLinearArc extends BaseArc {

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
     * 线性颜色
     */
    private int[] colors;

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

    public int[] getColors() {
        return colors;
    }

    public void setColors(int[] colors) {
        this.colors = colors;
    }

    @Override
    public void draw(Canvas canvas, Paint paint, int sideLength) {
        sideLength = sideLength / 2;
        canvas.save();

        Shader mShader = new SweepGradient(sideLength, sideLength, colors, generatePositions());
        paint.setShader(mShader);// 用Shader中定义定义的颜色
        paint.setStrokeCap(paintCap);
        paint.setStrokeWidth(strokeWidth);
        paint.setStyle(Paint.Style.STROKE);
        RectF rectF = new RectF();
        rectF.set(
                sideLength - radius,
                sideLength - radius,
                sideLength + radius,
                sideLength + radius
        );
        canvas.drawArc(rectF, startArc, endArc, false, paint);
        canvas.restore();
    }

    /**
     * 生成colors定点
     *
     * @return
     */
    private float[] generatePositions() {
        float startArcPosition = startArc * 1.0f / 360;
        float endArcPosition = (endArc + startArc) * 1.0f / 360;
        float degree = (endArcPosition - startArcPosition) * 1.0f / (colors.length - 1) * 1.0f;

        float[] positions = new float[colors.length];
        for (int i = 0; i < colors.length; i++) {
            positions[i] = startArcPosition + degree * i;
        }
        if (positions[0] != 0) {
            positions[0] -= 0.008;
        }
        if (positions[positions.length - 1] != 360) {
            positions[positions.length - 1] += 0.008;
        }
        return positions;
    }
}
