package com.example.martin.dashboardview.property.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class BaseIndicator {
    public abstract void draw(Canvas canvas, Paint paint, int sideLength);
}
