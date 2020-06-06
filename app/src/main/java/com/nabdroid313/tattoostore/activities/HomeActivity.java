package com.nabdroid313.tattoostore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.nabdroid313.tattoostore.MailsActivity;
import com.nabdroid313.tattoostore.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView startGameIV, mailIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
        init();

        startGameIV.setOnClickListener(this);

        mailIV.setOnClickListener(this);


    }



    private void init() {
        startGameIV = findViewById(R.id.startGameIV);
        mailIV = findViewById(R.id.mailIV);
    }





    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.startGameIV:
                startActivity(new Intent(HomeActivity.this, DrawingActivity.class));
                break;

            case R.id.mailIV:
                startActivity(new Intent(HomeActivity.this, MailsActivity.class));
                break;
        }

    }
}
