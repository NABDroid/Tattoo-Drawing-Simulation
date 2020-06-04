package com.nabdroid313.tattoostore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.nabdroid313.tattoostore.PaintView;
import com.nabdroid313.tattoostore.R;

import java.util.UUID;


public class DrawingActivity extends AppCompatActivity {

    private PaintView paintView;
    private int defaultColor;
    private Button blackButton, redButton, greenButton, blueButton;
    private ImageView undoIV, redoIV, clearIV, saveIV, fatLineIV, thinLineIV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        init();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        paintView.initialise(displayMetrics);
        paintView.setStrokeWidth(10);





//---------------------------blackButton------------------------------------------------------------------
        blackButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                defaultColor = Color.BLACK;
                paintView.setColor(defaultColor);
            }

        });

//---------------------------redButton--------------------------------------------------------------------
        redButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                defaultColor = Color.rgb(214, 42,42);
                paintView.setColor(defaultColor);

            }

        });

//----------------------------blueButton-------------------------------------------------------------------
        blueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                defaultColor = Color.rgb(63, 81, 181);
                paintView.setColor(defaultColor);

            }

        });

//------------------------------greenButton---------------------------------------------------------------
        greenButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                defaultColor = Color.rgb(76, 175,80);
                paintView.setColor(defaultColor);

            }

        });

//--------------------------------redoIV------------------------------------------------------------------
        redoIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.redo();
            }
        });

//---------------------------------undoIV-----------------------------------------------------------------
        undoIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.undo();

            }
        });

//---------------------------------clearIV-----------------------------------------------------------------
        clearIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.clear();

            }
        });

//---------------------------------saveIV------------------------------------------------------------------
        saveIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                paintView.deleteCursor();
                paintView.setDrawingCacheEnabled(true);
                String imgSaved = MediaStore.Images.Media.insertImage(getContentResolver(), paintView.getDrawingCache(), String.valueOf(UUID.randomUUID()), "Paintings");
                if (imgSaved != null){
                    Toast.makeText(DrawingActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(DrawingActivity.this, "Error! Image didn't saved!", Toast.LENGTH_SHORT).show();
                }
                paintView.destroyDrawingCache();

            }
        });
//---------------------------------fatLineButton-----------------------------------------------------------
        fatLineIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setStrokeWidth(40);

            }
        });



//---------------------------------ThinlineButton----------------------------------------------------------
        thinLineIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setStrokeWidth(10);

            }
        });


    }

    private void init() {
        paintView = findViewById(R.id.paintView);
        blackButton = findViewById(R.id.black_color);
        redButton = findViewById(R.id.red_color);
        greenButton = findViewById(R.id.green_color);
        blueButton = findViewById(R.id.blue_color);
        fatLineIV = findViewById(R.id.fatLineButton);
        thinLineIV = findViewById(R.id.thinLineButton);
        undoIV = findViewById(R.id.undoIV);
        redoIV = findViewById(R.id.redoIV);
        saveIV = findViewById(R.id.saveIV);
        clearIV = findViewById(R.id.clearIV);
    }

}
