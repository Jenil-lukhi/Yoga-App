package com.example.yogaapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class SecondActivity2 extends AppCompatActivity {

    int[] newArray;
    private AdView mAdView,mAdView1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd (adRequest);

        mAdView1 = findViewById(R.id.adView1);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView1.loadAd (adRequest1);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);



        newArray = new int[]{

                R.id.bow_pose1,R.id.bridge_pose2,R.id.chair_pose3,R.id.child_pose4,R.id.cobbler_pose5,R.id.cow_pose6
                ,R.id.playji_pose7,R.id.pauseji_pose8,R.id.plank_pose9,R.id.crunches_pose10,R.id.situp_pose11,R.id.rotation_pose12
                ,R.id.twist_pose13,R.id.windmill_pose14,

        };


    }





    public void Imagebuttonclicked(View view) {
        for (int i = 0; i < newArray.length; i++) {
            if (view.getId() == newArray[i]) {
                int value = i+1;
                Log.i("FIRST",String.valueOf(value));
                Intent intent = new Intent(SecondActivity2.this,ThirdActivity2.class);
                intent.putExtra("value", String.valueOf(value));
                startActivity(intent);

            }
        }
    }

}