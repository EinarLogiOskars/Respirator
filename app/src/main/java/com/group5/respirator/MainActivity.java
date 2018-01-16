package com.group5.respirator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.group5.respirator.Communication.Communication_akt;
import com.group5.respirator.Entertainment.EntertainmentScreen;
import com.group5.respirator.R;
import com.group5.respirator.Settings.SettingsActivity;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

        date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

        Timeviewer = findViewById(R.id.timeView);

        callButton = findViewById(R.id.callBtn);
        entertainmentButton = findViewById(R.id.entBtn);
        commnunicationButton = findViewById(R.id.comBtn);
        settingsButton = findViewById(R.id.settingBtn);

        Timeviewer.setText("Den aktuelle dato og tid\n"+date);

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
