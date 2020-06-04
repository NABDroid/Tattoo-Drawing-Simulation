package com.nabdroid313.tattoostore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.nabdroid313.tattoostore.MailsActivity;
import com.nabdroid313.tattoostore.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView startGameIV, mailIV;
    private MediaPlayer homePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
        startMediaPlayer();
        init();

        startGameIV.setOnClickListener(this);

        mailIV.setOnClickListener(this);


        homePlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                startMediaPlayer();
            }
        });
    }

    private void startMediaPlayer() {
        if (homePlayer == null){
            homePlayer = MediaPlayer.create(this, R.raw.background_music);

        }
        homePlayer.start();
    }

    private void init() {
        startGameIV = findViewById(R.id.startGameIV);
        mailIV = findViewById(R.id.mailIV);
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopMediaPlayer();
    }

    private void stopMediaPlayer(){
        if (homePlayer != null){
            homePlayer.release();
            homePlayer = null;
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.startGameIV:
                stopMediaPlayer();
                startActivity(new Intent(HomeActivity.this, DrawingActivity.class));
                break;

            case R.id.mailIV:
                startActivity(new Intent(HomeActivity.this, MailsActivity.class));
                break;
        }

    }
}
