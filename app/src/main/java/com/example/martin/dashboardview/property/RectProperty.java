//package com.example.martin.dashboardview.property;
//
//import android.graphics.RectF;
//
//public class RectProperty {
//
//    /**
//     * 起始角度
//     */
//    private int startArc;
//
//    /**
//     * 结束角度
//     */
//    private int endArc;
//
//    /**
//     * 半径
//     */
//    private int radius;
//
//    private int strokeWidth;
//
//    private int color;
//
//    public RectProperty() {
//
//    }
//
//    public RectProperty(int sidePadding) {
//        radius = sidePadding;
//    }
//
//    public int getStartArc() {
//        return startArc;
//    }
//
//    public void setStartArc(int startArc) {
//        this.startArc = startArc;
//    }
//
//    public int getEndArc() {
//        return endArc;
//    }
//
//    public void setEndArc(int endArc) {
//        this.endArc = endArc;
//    }
//
//    public int getRadius() {
//        return radius;
//    }
//
//    public void setRadius(int radius) {
//        this.radius = radius;
//    }
//
//    public RectF toRectF(int mSideLength) {
//        mSideLength = mSideLength / 2;
//        RectF rectF = new RectF();
//        rectF.set(
//                mSideLength - radius,
//                mSideLength - radius,
//                mSideLength + radius,
//                mSideLength + radius
//        );
//        return rectF;
//    }
//}
