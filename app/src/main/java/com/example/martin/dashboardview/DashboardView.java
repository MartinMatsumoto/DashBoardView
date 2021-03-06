package com.example.martin.dashboardview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.BounceInterpolator;

import com.example.martin.dashboardview.property.Property;
import com.example.martin.dashboardview.property.Shape;
import com.example.martin.dashboardview.widget.arc.BaseArc;
import com.example.martin.dashboardview.widget.indicator.BaseIndicator;
import com.example.martin.dashboardview.widget.pointer.BasePointer;
import com.example.martin.dashboardview.widget.pointer.ShapePointer;

import java.util.ArrayList;
import java.util.List;

/**
 * 安全程度仪表盘
 *
 * @author zengguoqiang
 * @version 2018-08-15
 */

public class DashboardView extends View {

    private Paint mPaint;
    private Path mPath;

    private int mSideLength;

    private int maxScore = 100;
    private int currScore = 0;
    //当前需要旋转的数值
    private float rotateDegree = 0f;

    private List<BaseArc> arcs = new ArrayList<>();
    private List<BaseIndicator> indicators  = new ArrayList<>();
    private List<BasePointer> pointers = new ArrayList<>();

    public DashboardView(Context context) {
        this(context, null);
        init();
    }

    public DashboardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public DashboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        //方形线帽
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        //消除锯齿
        mPaint.setAntiAlias(true);
        //设置绘制轮廓
        mPaint.setStyle(Paint.Style.FILL);
//        setWillNotDraw(false);
//        setLayerType(LAYER_TYPE_HARDWARE, null);
        testData();

        setBackgroundColor(Color.BLUE);

        setCreditValueWithAnim(100);
    }

    private void testData() {
        /*SolidArc r = new SolidArc();
        r.setRadius(100);
        r.setStartArc(30);
        r.setEndArc(90);
        r.setColor(Color.WHITE);
        r.setStrokeWidth(20);
        r.setPaintCap(Paint.Cap.ROUND);
        arcs.add(r);

        HollowArc hr = new HollowArc();
        hr.setRadius(200);
        hr.setStartArc(90);
        hr.setEndArc(100);
        hr.setColor(Color.RED);
        hr.setStrokeWidth(30);
        hr.setHollowStrokeWidth(10);
        hr.setPaintCap(Paint.Cap.ROUND);
        arcs.add(hr);

        HorizontalLinearArc hlr = new HorizontalLinearArc();
        hlr.setRadius(300);
        hlr.setStartArc(70);
        hlr.setEndArc(230);
        hlr.setColor(Color.WHITE);
        hlr.setStrokeWidth(30);
        hlr.setPaintCap(Paint.Cap.ROUND);
        hlr.setColors(new int[]{Color.CYAN, Color.RED, Color.YELLOW, Color.DKGRAY});
        arcs.add(hlr);

        RadialLinearArc rlr = new RadialLinearArc();
        rlr.setRadius(300);
        rlr.setStartArc(70);
        rlr.setEndArc(230);
        rlr.setColor(Color.WHITE);
        rlr.setStrokeWidth(30);
        rlr.setPaintCap(Paint.Cap.ROUND);
        rlr.setColors(new int[]{Color.CYAN, Color.RED, Color.YELLOW, Color.GREEN});
        rlr.setDashEffect(new float[]{60,50});
        arcs.add(rlr);*/



        /*RectIndicator ri = new RectIndicator();
        ri.setRadius(300);
        ri.setStartArc(0);
        ri.setEndArc(360);
        ri.setCount(16);
        ri.setCircleRadius(1);
        ri.setCircleRadiusOffset(30);

        ri.setColor(Color.WHITE);
        ri.setWidth(10);
        ri.setHeight(10);
        ri.setStrokeWidth(20);
        ri.setOffSetCount(1);

        ri.setColorOffset(Color.WHITE);
        ri.setStrokeWidthOffset(20);
        ri.setOffSet(20);
        ri.setRectType(RectIndicator.OVAL);
        indicators.add(ri);*/

        /*RectPointer lp = new RectPointer();
        lp.setHeight(300);
        lp.setWidth(30);
        lp.setOffset(30);
        lp.setRectType(RectPointer.ROUND_RECT);
        lp.setCircleRadius(10);
        lp.setStrokeWidth(5);
        lp.setColor(Color.GREEN);
        pointers.add(lp);*/

        /*TrianglePointer tp = new TrianglePointer();
        tp.setHeight(300);
        tp.setWidth(300);
        tp.setOffset(30);
        tp.setRectType(RectPointer.ROUND_RECT);
        tp.setCircleRadius(10);
        tp.setStrokeWidth(5);
        tp.setColor(Color.GREEN);
        pointers.add(tp);*/

        /*EchelonPointer ep = new EchelonPointer();
        ep.setHeight(300);
        ep.setWidth(100);
        ep.setOffset(30);
        ep.setRectType(RectPointer.ROUND_RECT);
        ep.setCircleRadius(20);
        ep.setStrokeWidth(5);
        ep.setTopWidth(200);
        ep.setColor(Color.GREEN);
        pointers.add(ep);*/

//        pointers.add(new CombinedPointer());


        ShapePointer shapePointer1 = new ShapePointer();
        Property property = new Property();
        property.setShape(Shape.RECTANGLE);
        property.setWidth(300);
        property.setHeight(300);
        property.setColor(Color.BLACK);
        shapePointer1.setProperty(property);
        property.setShape(Shape.CIRCULAR);

        ShapePointer shapePointer2 = new ShapePointer();
        Property property2 = new Property();
        property2.setShape(Shape.TRIANGLE);
        property2.setWidth(100);
        property2.setHeight(100);
        property2.setColor(Color.WHITE);
        shapePointer2.setProperty(property2);
        property.setShape(Shape.CIRCULAR);

        ShapePointer shapePointer3 = new ShapePointer();
        Property property3 = new Property();
        property3.setShape(Shape.CIRCULAR);
        property3.setWidth(100);
        property3.setHeight(100);
        property3.setColor(Color.WHITE);
        shapePointer3.setProperty(property3);
        property.setShape(Shape.CIRCULAR);


        pointers.add(shapePointer1);
        pointers.add(shapePointer2);
        pointers.add(shapePointer3);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制画布背景
//        canvas.drawColor(Color.GRAY, PorterDuff.Mode.SRC);
        //绘制直线
//        canvas.drawLine(0, 0, mSideLength, mSideLength, mPaint);
        drawArcs(canvas);
//        drawNomal(canvas);
    }

    private void drawArcs(Canvas canvas) {
        for (BaseArc arc : arcs) {
            arc.draw(canvas, mPaint, mSideLength);
        }

        for (BaseIndicator arc : indicators) {
            arc.draw(canvas, mPaint, mSideLength);
        }

        for (BasePointer arc : pointers) {
            arc.draw(canvas, mPaint, mSideLength, rotateDegree);
        }
    }

    /**
     * 设置值并播放动画
     *
     * @param creditValue 值
     */
    public void setCreditValueWithAnim(int creditValue) {
        currScore = creditValue;
        ValueAnimator creditValueAnimator = ValueAnimator.ofInt(0, 100);
        creditValueAnimator.setDuration(1500);
        creditValueAnimator.setInterpolator(new BounceInterpolator());
        ValueAnimator.setFrameDelay(10);
        creditValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currValue = (int) animation.getAnimatedValue();
                rotateDegree = currValue * 1.0f / 100 * 360 * 1.0f;
                postInvalidate();
            }
        });
        creditValueAnimator.start();
    }

    /**
     * 常规绘制  以(0,0)作为坐标原点参考点
     *
     * @param canvas
     */
    private void drawNomal(Canvas canvas) {
        mPaint = new Paint();
        // 绘制画布背景
        canvas.drawColor(Color.GRAY);
        //设置画笔颜色
        mPaint.setColor(Color.BLUE);
        //设置画笔为空心     如果将这里改为Style.STROKE  这个图中的实线圆柱体就变成了空心的圆柱体
        mPaint.setStyle(Paint.Style.STROKE);
        //绘制直线
        canvas.drawLine(50, 50, 450, 50, mPaint);
        //绘制矩形
        canvas.drawRect(100, 100, 200, 300, mPaint);
        //绘制矩形
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(300, 100, 400, 400, mPaint);
        mPaint.setColor(Color.YELLOW);
        RectF r = new RectF(150, 500, 270, 600);
        // 画矩形
        canvas.drawRect(r, mPaint);
        // 画圆
        canvas.drawCircle(50, 500, 50, mPaint);
        RectF oval = new RectF(350, 500, 450, 700);
        // 画椭圆
        canvas.drawOval(oval, mPaint);
        RectF rect = new RectF(100, 700, 170, 800);
        // 画圆角矩形
        canvas.drawRoundRect(rect, 30, 20, mPaint);
        //绘制圆弧 绘制弧形
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        RectF re1 = new RectF(1000, 50, 1400, 200);
        canvas.drawArc(re1, 10, 270, false, mPaint);
        RectF re2 = new RectF(1000, 300, 1400, 500);
        canvas.drawArc(re2, 10, 270, true, mPaint);
        //设置Path路径
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(3);
        Path path = new Path();
        path.moveTo(500, 100);
        path.lineTo(920, 80);
        path.lineTo(720, 200);
        path.lineTo(600, 400);
        path.close();
        mPaint.setTextSize(46);
        canvas.drawPath(path, mPaint);
        canvas.drawTextOnPath("7qiuwoeruowoqjifasdkfjksjfiojio23ur8950", path, -20, -20, mPaint);
        //三角形
        path.moveTo(10, 330);
        path.lineTo(70, 330);
        path.lineTo(40, 270);
        path.close();
        canvas.drawPath(path, mPaint);
        //把开始的点和最后的点连接在一起，构成一个封闭梯形
        path.moveTo(10, 410);//绘画基点
        path.lineTo(70, 410);
        path.lineTo(55, 350);
        path.lineTo(25, 350);
        //如果是Style.FILL的话，不设置close,也没有区别，可是如果是STROKE模式， 如果不设置close,图形不封闭。当然，你也可以不设置close，再添加一条线，效果一样。
        path.close();
        canvas.drawPath(path, mPaint);
        //参数一为渐变起初点坐标x位置，参数二为y轴位置，参数三和四分辨对应渐变终点,其中参数new int[]{startColor, midleColor,endColor}是参与渐变效果的颜色集合，
        // 其中参数new float[]{0 , 0.5f, 1.0f}是定义每个颜色处于的渐变相对位置， 这个参数可以为null，如果为null表示所有的颜色按顺序均匀的分布
        // Shader.TileMode三种模式
        // REPEAT:沿着渐变方向循环重复
        // CLAMP:如果在预先定义的范围外画的话，就重复边界的颜色
        // MIRROR:与REPEAT一样都是循环重复，但这个会对称重复
        Shader mShader = new LinearGradient(0, 0, 100, 100,
                new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW},
                null, Shader.TileMode.REPEAT);
        mPaint.setShader(mShader);// 用Shader中定义定义的颜色来话
        mPaint.setStyle(Paint.Style.FILL);
        Path path1 = new Path();
        path1.moveTo(170, 410);
        path1.lineTo(230, 410);
        path1.lineTo(215, 350);
        path1.lineTo(185, 350);
        path1.close();
        canvas.drawPath(path1, mPaint);
        canvas.save();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (heightSize > widthSize) {
            mSideLength = widthSize;
        } else {
            mSideLength = heightSize;
        }
        setMeasuredDimension(mSideLength, mSideLength);
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                Resources.getSystem().getDisplayMetrics());
    }

}
