package com.nabdroid313.tattoostore;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class MailsActivity extends AppCompatActivity {
    private Bitmap bitmap;
    int[][] matrix;
    private TextView arrayTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mails);
        arrayTV = findViewById(R.id.arrayTV);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.level_one_tattoo);
        bitmap = Bitmap.createScaledBitmap(bitmap, 200, 200, false);
        matrix = new int[200][200];

        getArray();

        Toast.makeText(this, "75,75"+matrix[75][75], Toast.LENGTH_SHORT).show();





    }


    private void getArray(){
        for (int i = 0; i<200; i++){
            for (int j = 0; j<200; j++){
                matrix[i][j] =  bitmap.getPixel(i,j);


            }
        }
    }




}
