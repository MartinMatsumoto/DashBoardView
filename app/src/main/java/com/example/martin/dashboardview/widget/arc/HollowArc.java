package com.example.martin.dashboardview.widget.arc;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;

public class HollowArc extends BaseArc {

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
     * 空心宽度
     */
    private int hollowStrokeWidth;

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

    public int getHollowStrokeWidth() {
        return hollowStrokeWidth;
    }

    public void setHollowStrokeWidth(int hollowStrokeWidth) {
        this.hollowStrokeWidth = hollowStrokeWidth;
    }

    @Override
    public void draw(Canvas canvas, Paint paint, int sideLength) {
        sideLength = sideLength / 2;

        canvas.save();
        paint.setShader(null);
        paint.setXfermode(null);
        paint.setColor(color);
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


        RectF rectF2 = new RectF();
        rectF2.set(
                sideLength - radius,
                sideLength - radius,
                sideLength + radius,
                sideLength + radius
        );



        /*paint.setStrokeWidth(hollowStrokeWidth);
        paint.setColor(Color.RED);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));*/


        Paint transparentPaint = new Paint();


//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
//        paint.setStrokeWidth(hollowStrokeWidth);
//        paint.setColor(Color.parseColor("#00000000"));

        transparentPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        transparentPaint.setColor(Color.WHITE);
        transparentPaint.setStrokeCap(paintCap);
        transparentPaint.setStrokeWidth(hollowStrokeWidth);
        transparentPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF2, startArc, endArc, false, transparentPaint);
        canvas.restore();
    }

}
