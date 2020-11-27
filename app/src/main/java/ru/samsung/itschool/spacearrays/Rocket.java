package ru.samsung.itschool.spacearrays;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class Rocket extends BaseObject implements Moveable, Touchable{
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
    public void move(){
        double x = getX();
        double  y = getY();
        setX(x + vx);
        setY(y + vy);
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        Matrix matrix = new Matrix();
        matrix.setScale(0.2f, 0.2f);
        //Study mathematics, dear young programmer :)
        /*if (getX() < 30) {
            vx *= -1;

            double y = getY();
            setX(y - 120);
        }
        if (getX() > w - 30) {
            vx *= -1;
            double y = getY();
            setX(y - 120);
        }
        if (getY() < 30){
            vy *= -1;
            double x = getX();
            setX(x + 120);
        }
        if (getY() > h - 30){
            vy *= -1;
            double x = getX();
            setX(x - 120);
        }*/

        matrix.postRotate((float)Math.toDegrees(Math.atan2(vy, vx)) + 45);
        matrix.postTranslate((float)getX(), (float)getY());
        paint.setAlpha(255);
        canvas.drawBitmap(image, matrix, paint);
    }

    @Override
    public void touch(float x, float y) {
        if (Math.abs(getX() - x ) <= 100 && Math.abs(getY() - y) <= 100) {
            setY(y + 120);
            setX(x - 120);
        }
    }
}