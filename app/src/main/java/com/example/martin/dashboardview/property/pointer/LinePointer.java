package com.example.martin.dashboardview.property.pointer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class LinePointer extends BasePointer {

    @Override
    public void draw(Canvas canvas, Paint paint, int sideLength) {
        int width = 50;
        int height = 300;
        sideLength = sideLength / 2;

        RectF rectF = new RectF();
        rectF.set(
                sideLength + 10,
                sideLength+ 10,
                sideLength + width / 2,
                sideLength + height / 2
        );
        canvas.drawRect(rectF, paint);
    }
}
