package com.example.martin.dashboardview.property.pointer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

public class LinePointer extends BasePointer {

    @Override
    public void draw(Canvas canvas, Paint paint, int sideLength,float rotateDegree) {
        int width = 50;
        int height = 300;
        sideLength = sideLength / 2;
        canvas.save();

        canvas.rotate(rotateDegree, sideLength, sideLength);
        RectF rectF = new RectF();
        rectF.set(
                sideLength - width / 2,
                sideLength - height,
                sideLength + width / 2,
                sideLength
        );
        canvas.drawRect(rectF, paint);

        canvas.restore();
    }
}
