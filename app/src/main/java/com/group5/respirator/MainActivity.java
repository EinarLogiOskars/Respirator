package com.group5.respirator;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.group5.respirator.Communication.Communication_akt;
import com.group5.respirator.Entertainment.EntertainmentScreen;
import com.group5.respirator.Settings.SettingsActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity implements OnClickListener
{

    private TextView Timeviewer;
    private Button callButton;
    private Button entertainmentButton;
    private Button commnunicationButton;
    private Button settingsButton;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());

        Timeviewer = findViewById(R.id.timeView);

        callButton = findViewById(R.id.callBtn);
        entertainmentButton = findViewById(R.id.entBtn);
        commnunicationButton = findViewById(R.id.comBtn);
        settingsButton = findViewById(R.id.settingBtn);

        final Handler someHandler = new Handler(getMainLooper());
        someHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Timeviewer.setText("Den aktuelle dato og tid\n"+date);
                //Timeviewer.setText("Den aktuelle dato og tid\n"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
                Timeviewer.setText("Den aktuelle dato og tid\n" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime()));
                someHandler.postDelayed(this, 1000);
            }
        }, 10);

        callButton.setOnClickListener(this);
        entertainmentButton.setOnClickListener(this);
        commnunicationButton.setOnClickListener(this);
        settingsButton.setOnClickListener(this);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public void communication()
    {

        Intent comIntent = new Intent(this, Communication_akt.class);
        startActivity(comIntent);

    }

    public void entertainment() {

        Intent entIntent = new Intent(this, EntertainmentScreen.class);
        startActivity(entIntent);
    }

    public void settings() {

        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        startActivity(settingsIntent);

    }

    public void call() {
        Intent callIntent = new Intent(this,CallActivity.class);
        startActivity(callIntent);
    }

    public void QuickTapButton(View v)
    {
        AlphaAnimation alphaDown = new AlphaAnimation(1.0f, 0.3f);
        AlphaAnimation alphaUp = new AlphaAnimation(0.3f, 1.0f);
        alphaDown.setDuration(1000);
        alphaUp.setDuration(500);
        alphaDown.setFillAfter(true);
        alphaUp.setFillAfter(true);
        v.startAnimation(alphaUp);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.callBtn:
                QuickTapButton(v);
                call();
                break;
            case R.id.comBtn:
                QuickTapButton(v);
                communication();
                break;
            case R.id.settingBtn:
                QuickTapButton(v);
                settings();
                break;
            case R.id.entBtn:
                QuickTapButton(v);
                entertainment();
                break;
            default:
                break;
        }

    }
}
