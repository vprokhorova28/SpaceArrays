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
		sky = new Sky();
		rocket = new Rocket[10];
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		for (int i = 0; i < rocket.length; i++) {
			rocket[i] =  new Rocket((float)(Math.random() * getWidth()), (float)(Math.random() * getHeight()), (float)(Math.random() * 6 - 3), (float)(Math.random() * 6 - 3), rocketImage);
		}
	}


	Paint paint = new Paint();
	Bitmap rocketImage = BitmapFactory.decodeResource(getResources(), R.drawable.rocket);

	

	Sky sky;
	Rocket[] rocket;

	
	@Override
	protected void onDraw(Canvas canvas) {
		
		sky.draw(canvas);

		for (int i = 0; i < rocket.length; i++) {
			rocket[i].draw(canvas, paint);
			rocket[i].move();

		}


	// Запрос на перерисовку экрана
		invalidate();
	}
	

	


	/*@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		/*xRocket[N] = x - 120;
		yRocket[N] = y - 120;
		vxRocket[N] = (float)(Math.random() * 6 - 3);
		vyRocket[N] = (float)(Math.random() * 6 - 3);
		N++;
		return false;
	}*/
}
