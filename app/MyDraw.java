package ru.samsung.itschool.spacearrays;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyDraw extends View {

    public MyDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
        rocket = new Rocket[10];
        bos = new BaseObject[rocket.length];
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        for (int i = 0; i < rocket.length; i++) {
            rocket[i] = new Rocket((float) (Math.random() * getWidth()),
                    (float) (Math.random() * getHeight()),
                    (float) (Math.random() * 6 - 3),
                    (float) (Math.random() * 6 - 3),
                    rocketImage,
                    getWidth(),
                    getHeight());
        }
        System.arraycopy(rocket, 0, bos, 0, rocket.length);
        sky = new Sky(getWidth(), getHeight(), 250);
    }


    Paint paint = new Paint();
    Bitmap rocketImage = BitmapFactory.decodeResource(getResources(), R.drawable.rocket);


    Sky sky;
    Rocket[] rocket;
    BaseObject[] bos;


    @Override
    protected void onDraw(Canvas canvas) {

        sky.draw(canvas);


        for (Rocket value : rocket) {
            value.draw(canvas);
            value.move();

        }


        // Запрос на перерисовку экрана
        invalidate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        for (BaseObject b : bos) {
            if (b instanceof Touchable) {
                ((Touchable) b).touch(x, y);
            }
        }
        return true;
    }
}
