package com.example.martin.dashboardview.property;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class Property {

    /**
     * 宽
     */
    private int width;

    /**
     * 顶部宽
     */
    private int topWidth;

    /**
     * 高
     */
    private int height;

    /**
     * X偏移量
     */
    private int offsetX = 0;

    /**
     * Y偏移量
     */
    private int offsetY = 0;

    /**
     * 旋转角度
     */
    private float rotateDegree;

    /**
     * 圆角角度
     */
    private float angleRadius = 0;

    /**
     * 颜色
     */
    private int color = Color.WHITE;

    /**
     * 线宽
     */
    private int strokeWidth;

    /**
     * 透明度
     */
    private int alpha = 255;

    /**
     * 起始角度
     */
    private int startArc = 0;

    /**
     * 结束角度
     */
    private int endArc = 360;

    /**
     * 半径
     */
    private int radius = 0;

    /**
     * 线性颜色
     */
    private int[] colors;

    /**
     * 虚线
     */
    private float[] dashEffect;

    /**
     * 线帽
     * ROUND / SQUARE
     */
    private Paint.Cap paintCap = Paint.Cap.SQUARE;

    /**
     * 是否填充
     */
    private Paint.Style paintStyle = Paint.Style.FILL;

    /**
     * 形状
     */
    private int shape;

    /**
     * 混合类型
     */
    private Path.FillType fillType;

    /**
     * 设置笔画属性
     * @param paint
     */
    public void setPaint(Paint paint){
        paint.setStrokeWidth(getStrokeWidth());
        paint.setStyle(getPaintStyle());
        paint.setColor(getColor());
    }

    public Paint.Style getPaintStyle() {
        return paintStyle;
    }

    public void setPaintStyle(Paint.Style paintStyle) {
        this.paintStyle = paintStyle;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getTopWidth() {
        return topWidth;
    }

    public void setTopWidth(int topWidth) {
        this.topWidth = topWidth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    public float getRotateDegree() {
        return rotateDegree;
    }

    public void setRotateDegree(float rotateDegree) {
        this.rotateDegree = rotateDegree;
    }

    public float getAngleRadius() {
        return angleRadius;
    }

    public void setAngleRadius(float angleRadius) {
        this.angleRadius = angleRadius;
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

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

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

    public int[] getColors() {
        return colors;
    }

    public void setColors(int[] colors) {
        this.colors = colors;
    }

    public float[] getDashEffect() {
        return dashEffect;
    }

    public void setDashEffect(float[] dashEffect) {
        this.dashEffect = dashEffect;
    }

    public Paint.Cap getPaintCap() {
        return paintCap;
    }

    public void setPaintCap(Paint.Cap paintCap) {
        this.paintCap = paintCap;
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }

    public Path.FillType getFillType() {
        return fillType;
    }

    public void setFillType(Path.FillType fillType) {
        this.fillType = fillType;
    }
}
