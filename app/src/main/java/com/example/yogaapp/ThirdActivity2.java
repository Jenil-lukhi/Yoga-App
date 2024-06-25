package com.example.yogaapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity2 extends AppCompatActivity {

    String buttonvalue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mTextview;
    private boolean MTimeRunnig;
    private long MTimeLeftinmills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");

        int intvalue = Integer.valueOf(buttonvalue);

        switch (intvalue) {

            case 1:
                setContentView(R.layout.activity_bow1);
                break;
            case 2:
                setContentView(R.layout.activity_bridge2);
                break;
            case 3:
                setContentView(R.layout.activity_chair3);
                break;
            case 4:
                setContentView(R.layout.activity_child4);
                break;
            case 5:
                setContentView(R.layout.activity_cobbler5);
                break;
            case 6:
                setContentView(R.layout.activity_cow6);
                break;
            case 7:
                setContentView(R.layout.activity_playji7);
                break;
            case 8:
                setContentView(R.layout.activity_pauseji8);
                break;
            case 9:
                setContentView(R.layout.activity_plank9);
                break;
            case 10:
                setContentView(R.layout.activity_crunche10);
                break;
            case 11:
                setContentView(R.layout.activity_situp11);
                break;
            case 12:
                setContentView(R.layout.activity_rotation12);
                break;
            case 13:
                setContentView(R.layout.activity_twist13);
                break;
            case 14:
                setContentView(R.layout.activity_windmill14);
                break;




        }

        startBtn = findViewById(R.id.startbutton);
        mTextview = findViewById(R.id.time);





        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MTimeRunnig) {
                    stoptimer();
                } else {
                    startTimer();
                }
            }
        });


    }

    private void stoptimer() {
        countDownTimer.cancel();
        MTimeRunnig = false;
        startBtn.setText("START");


    }

    private void startTimer()
    {
        final CharSequence value1 = mTextview.getText();
        String num1 = value1.toString();
        String num2 = num1.substring(0,2);
        String num3 = num1.substring(3,5);

        final int number = Integer.valueOf(num2) * 60+ Integer.valueOf(num3);
        MTimeLeftinmills = number*1000;


        countDownTimer = new CountDownTimer(MTimeLeftinmills,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                MTimeLeftinmills = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                int newvalue = Integer.valueOf(buttonvalue)+1;
                if (newvalue<=7){

                    Intent intent = new Intent(ThirdActivity2.this,ThirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);

                }
                else {

                    newvalue = 1;
                    Intent intent =new Intent(ThirdActivity2.this,ThirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);



                }

            }
        }.start();
        startBtn.setText("PAUSE");
        MTimeRunnig=true;

    }

    private void updateTimer()
    {
        int minutes = (int) MTimeLeftinmills/60000;
        int seconds = (int) MTimeLeftinmills%60000 /1000;
        String timeLeftText="";
        if (minutes<10)
            timeLeftText="0";
        timeLeftText = timeLeftText+minutes+":";
        if (seconds<10)
            timeLeftText+="0";
        timeLeftText+=seconds;
        mTextview.setText(timeLeftText);
    }

}