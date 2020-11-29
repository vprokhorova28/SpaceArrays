package ru.samsung.itschool.spacearrays;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

public class Rocket extends BaseObject implements Moveable, Touchable {
    private float vx, vy;
    private Bitmap image;
    private int w, h;

    Rocket(float x, float y, float vx, float vy, Bitmap image, int w, int h) {
        super(x, y);
        this.w = w;
        this.h = h;
        this.vx = vx;
        this.vy = vy;
        this.image = image;
    }

    @Override
    public void move() {
        double x = getX();
        double y = getY();
        setX(x + vx);
        setY(y + vy);
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        Matrix matrix = new Matrix();
        matrix.setScale(0.2f, 0.2f);
        //Study mathematics, dear young programmer :)
        matrix.postRotate((float) Math.toDegrees(Math.atan2(vy, vx)) + 45);
        matrix.postTranslate((float) getX(), (float) getY());
        paint.setAlpha(255);
        canvas.drawBitmap(image, matrix, paint);
        if (getY() + image.getHeight() < 0) {
            vy *= -1;
        } else if (getY() > h) {
            vy *= -1;
        }
        if (getX() + image.getWidth() < 0) {
            vx *= -1;
        } else if (getX() > w) {
            vx *= -1;
        }
    }

    @Override
    public void touch(float x, float y) {
        double degree = -Math.atan2(vy, vx) + Math.PI / 4;
        double x1 = getX();
        double x2 = getY();
        double hip = Math.sqrt(2) * 300;
        double x0 = getX() + hip * Math.cos(degree);
        double y0 = getY() + hip * Math.sin(degree);
        if (Math.abs(x0 - x) <= hip && Math.abs(y0 - y) <= hip) {
            vx *= 2;
            vy *= 2;
        }
    }
}