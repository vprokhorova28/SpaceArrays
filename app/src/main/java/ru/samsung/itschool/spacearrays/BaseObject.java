package ru.samsung.itschool.spacearrays;

import android.graphics.Canvas;

abstract class BaseObject implements Drawable {
    private double x, y;

    BaseObject(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public abstract void draw(Canvas c);
}
