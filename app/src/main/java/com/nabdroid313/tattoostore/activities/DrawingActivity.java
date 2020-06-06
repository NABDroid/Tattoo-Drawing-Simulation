package com.nabdroid313.tattoostore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.nabdroid313.tattoostore.PaintView;
import com.nabdroid313.tattoostore.R;

public class DrawingActivity extends AppCompatActivity implements View.OnClickListener {

    private PaintView paintView;
    private int defaultColor;
    private Button blackButton, redButton, greenButton, blueButton, submitButton;
    private ImageView undoIV, redoIV, fatLineIV, thinLineIV, demoImage;
    int level = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        init();

//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        paintView.initialise(level);
        paintView.setStrokeWidth(10);
        blackButton.setOnClickListener(this);
        redButton.setOnClickListener(this);
        blueButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);
        redoIV.setOnClickListener(this);
        undoIV.setOnClickListener(this);
        submitButton.setOnClickListener(this);
        fatLineIV.setOnClickListener(this);
        thinLineIV.setOnClickListener(this);

        setDemoImage();


    }

    private void setDemoImage() {
        switch (level){
            case 1: demoImage.setImageResource(R.drawable.anchor);
            break;
            case 2: demoImage.setImageResource(R.drawable.wings);
            break;
            default: demoImage.setImageResource(R.drawable.ic_mute);

        }
    }

    private void init() {
        demoImage = findViewById(R.id.showDemo);
        paintView = findViewById(R.id.paintView);
        blackButton = findViewById(R.id.black_color);
        redButton = findViewById(R.id.red_color);
        greenButton = findViewById(R.id.green_color);
        blueButton = findViewById(R.id.blue_color);
        fatLineIV = findViewById(R.id.fatLineIV);
        thinLineIV = findViewById(R.id.thinLineIV);
        undoIV = findViewById(R.id.undoIV);
        redoIV = findViewById(R.id.redoIV);
        submitButton = findViewById(R.id.submitButton);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.black_color:
                defaultColor = Color.BLACK;
                paintView.setColor(defaultColor);
                break;
            case R.id.red_color:
                defaultColor = Color.rgb(214, 42, 42);
                paintView.setColor(defaultColor);
                break;

            case R.id.green_color:
                defaultColor = Color.rgb(76, 175, 80);
                paintView.setColor(defaultColor);
                break;

            case R.id.blue_color:
                defaultColor = Color.rgb(63, 81, 181);
                paintView.setColor(defaultColor);
                break;

            case R.id.undoIV:
                paintView.undo();
                break;

            case R.id.redoIV:
               paintView.redo();
                break;

            case R.id.submitButton:
                checkResult();
                break;

            case R.id.fatLineIV:
                paintView.setStrokeWidth(40);
                break;

            case R.id.thinLineIV:
                paintView.setStrokeWidth(10);
                break;
        }
    }

    private void checkResult() {
        boolean result = paintView.getResult();
        if (result){
            level++;
            setDemoImage();
            paintView.initialise(level);

        }
        else {
            Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();

        }
    }
}
