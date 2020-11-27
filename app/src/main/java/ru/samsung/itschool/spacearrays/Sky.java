package ru.samsung.itschool.spacearrays;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Sky implements Drawable{
    private Star[] stars;

    Sky(int w, int h, int n) {
        int maxX = w;
        int maxY = h;
        stars = new Star[n];
        for (int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star(Math.random() * maxX,
                    Math.random() * maxY,
                    (int)(Math.random() * 256));
        }
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        canvas.drawColor(Color.BLACK);
        for (Star star : stars) {
            star.draw(canvas);
        }
    }
}
