package com.example.martin.dashboardview.widget.pointer;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class BasePointer {

    public abstract void draw(Canvas canvas, Paint paint, int sideLength, float rotateDegree);
}
