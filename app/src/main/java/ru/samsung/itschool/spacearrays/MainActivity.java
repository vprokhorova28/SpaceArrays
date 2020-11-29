package ru.samsung.itschool.spacearrays;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private int n, color;
    private Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        n = getIntent().getIntExtra("et", 5);
        color = getIntent().getIntExtra("color", Color.YELLOW);
        setContentView(R.layout.activity_main);
        MyDraw md = findViewById(R.id.myDraw1);
        md.setRocketNumber(n);
        md.setStarsColor(color);
        btnClose = findViewById(R.id.x);
        btnClose.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.x) {
                finish();
            }
        }
    };
}