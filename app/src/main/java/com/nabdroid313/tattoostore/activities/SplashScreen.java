package com.nabdroid313.tattoostore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.nabdroid313.tattoostore.R;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
            }
        });
        thread.start();

    }


    private void doWork(){
        for (int progress = 1; progress<=20; progress = progress+1){
            try {
                Thread.sleep(50);
                if (progress>=20){
                    startActivity(new Intent(SplashScreen.this, HomeActivity.class));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                startActivity(new Intent(SplashScreen.this, HomeActivity.class));
            }
        }
    }
}
