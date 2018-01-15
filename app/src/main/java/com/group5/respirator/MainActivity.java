package com.group5.respirator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.group5.respirator.Communication.Communication_akt;
import com.group5.respirator.Entertainment.EntertainmentScreen;
import com.group5.respirator.R;
import com.group5.respirator.Settings.SettingsActivity;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView Timeviewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timeviewer = findViewById(R.id.timeView);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());



        Timeviewer.setText("Den aktuelle dato og tid\n"+date);
    }

    public void communication(View view) {

        Intent comIntent = new Intent(this, Communication_akt.class);
        startActivity(comIntent);

    }

    public void entertainment(View view) {

        Intent entIntent = new Intent(this, EntertainmentScreen.class);
        startActivity(entIntent);

    }

    public void settings(View view) {

        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        startActivity(settingsIntent);

    }
}
