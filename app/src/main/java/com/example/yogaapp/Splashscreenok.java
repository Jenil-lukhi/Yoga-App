package com.example.yogaapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splashscreenok extends AppCompatActivity {

    Animation up,down;
    ImageView imageView;

    private static final long SPLASH_DELAY = 3000;
            TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreenok);

        ImageView imageView = findViewById(R.id.appsplash);

//        up = AnimationUtils.loadAnimation (getApplicationContext(), R.anim.up);
//        imageView.setAnimation (up);
//
//
//
//        TextView textView = findViewById(R.id.appname);
//        down = AnimationUtils.loadAnimation (getApplicationContext(), R.anim.down);
//        textView.setAnimation (down);





        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(Splashscreenok.this, MainActivity.class);
                startActivity(intent);

            }
        }, SPLASH_DELAY);
    }

}