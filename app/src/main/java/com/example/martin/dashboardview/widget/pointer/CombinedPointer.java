package com.example.martin.dashboardview.widget.pointer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;

public class CombinedPointer  extends BasePointer {

    @Override
    public void draw(Canvas canvas, Paint paint, int sideLength, float rotateDegree) {
        sideLength = sideLength / 2;
        canvas.save();

        int width = 100;
        int topWidth = 200;
        int height = 300;


        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);

        canvas.rotate(rotateDegree, sideLength, sideLength);

        Path path = new Path();
        path.moveTo(sideLength, sideLength);
        path.rLineTo(width / 2, 0);
        path.rLineTo(-(width - topWidth) / 2, -height);
        path.rLineTo(-topWidth, 0);
        path.rLineTo(-(width - topWidth) / 2, height);
        path.close();

        Path path2 = new Path();
        path2.moveTo(sideLength , sideLength - 50);
        path2.rLineTo(width / 2, 0);
        path2.rLineTo(-width / 2, height);
        path2.rLineTo(-width / 2, -height);
        path2.close();

        path.setFillType(Path.FillType.WINDING);
        path2.setFillType(Path.FillType.WINDING);
        paint.setPathEffect(new CornerPathEffect(20));
        paint.setColor(Color.WHITE);
        paint.setAlpha(55);
        canvas.drawPath(path, paint);

        paint.setColor(Color.WHITE);
        paint.setAlpha(55);
        canvas.drawPath(path2, paint);

        canvas.restore();
    }
}
