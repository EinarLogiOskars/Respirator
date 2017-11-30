package com.group5.respirator.Settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.group5.respirator.Communication.Communication_akt;
import com.group5.respirator.Entertainment.EntertainmentScreen;
import com.group5.respirator.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


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
