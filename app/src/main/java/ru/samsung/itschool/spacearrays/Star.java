package ru.samsung.itschool.spacearrays;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Star extends BaseObject implements Drawable {
    private int alpha, color;

    public Star(double x, double y, int alpha, int color) {
        super(x, y);
        this.alpha = alpha;
        this.color = color;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(2);
        paint.setAlpha(alpha);
        alpha += (int) (Math.random() * 11) - 5;
        if (alpha > 255) alpha = 255;
        if (alpha < 0) alpha = 0;
        canvas.drawCircle((float) getX(), (float) getY(), 3, paint);
    }
}
