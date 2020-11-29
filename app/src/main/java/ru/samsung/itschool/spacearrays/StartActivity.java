package ru.samsung.itschool.spacearrays;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Random;

public class StartActivity extends Activity {
    private Button btnStart, btnClose;
    private Intent i;
    private EditText et;
    private RadioGroup rg;
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(listener);

        btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(listener);

        rg = findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(rblistener);

        RadioButton rbYellow = (RadioButton) findViewById(R.id.rbYellow);
        rbYellow.setOnClickListener(listener);

        RadioButton rbLYellow = (RadioButton) findViewById(R.id.rbLightYellow);
        rbLYellow.setOnClickListener(listener);

        RadioButton rbDYellow = (RadioButton) findViewById(R.id.rbDarkYellow);
        rbDYellow.setOnClickListener(listener);

        RadioButton rbWhite = (RadioButton) findViewById(R.id.rbWhite);
        rbWhite.setOnClickListener(listener);

        RadioButton rbMulticolored = (RadioButton) findViewById(R.id.rbMulticolored);
        rbMulticolored.setOnClickListener(listener);

        i = new Intent(StartActivity.this, MainActivity.class);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnStart:
                    et = findViewById(R.id.et);
                    try {
                        n = Integer.parseInt(et.getText().toString());
                    } catch (NumberFormatException e) {
                        n = 10;
                    }
                    i.putExtra("et", n);
                    startActivity(i);
                    break;
                case (R.id.btnClose):
                    finish();
            }
        }
    };

    RadioGroup.OnCheckedChangeListener rblistener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rbYellow:
                    StarColour yellow = StarColour.YELLOW;
                    i.putExtra("color", yellow.getColour());
                    break;
                case R.id.rbDarkYellow:
                    StarColour darkYellow = StarColour.DARK_YELLOW;
                    i.putExtra("color", darkYellow.getColour());
                    break;
                case R.id.rbLightYellow:
                    StarColour lightYellow = StarColour.LIGHT_YELLOW;
                    i.putExtra("color", lightYellow.getColour());
                    break;
                case R.id.rbWhite:
                    StarColour white = StarColour.WHITE;
                    i.putExtra("color", white.getColour());
                    break;
                case R.id.rbMulticolored:
                    Random r = new Random();
                    StarColour[] colors = StarColour.values();
                    i.putExtra("color", colors[(int) (Math.random() * (colors.length - 1))].getColour());
                    break;
            }
        }
    };
}