package com.example.martin.dashboardview.widget.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class BaseIndicator {
    public abstract void draw(Canvas canvas, Paint paint, int sideLength);
}
