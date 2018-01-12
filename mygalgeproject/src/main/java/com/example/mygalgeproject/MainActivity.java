package com.example.bijannegari.galgespilprojekt;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static Galgelogik logik = new Galgelogik();

    private Button button1;
    private Button button2;
    private Button highscoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        highscoreButton = (Button) findViewById(R.id.highscoreButton);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        highscoreButton.setOnClickListener(this);

        new AsyncTaskRunner().execute();
    }


    @Override
    public void onClick(View view) {
        if (view == button1){
            Intent intent = new Intent(this, ChooseWordManually.class);
            startActivity(intent);
        }
        else if(view == button2){
            ActivityCompat.finishAffinity(this);
        }
        else if(view == highscoreButton){
            Intent intent = new Intent(this, Highscore.class);
            startActivity(intent);
        }
    }


    private class AsyncTaskRunner extends AsyncTask<String, String, String>
    {
        private String response;
        final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

        protected String doInBackground(String... params)
        {
            try
            {
                logik.hentOrdFraDr();
                logik.nulstil();
            } catch (Exception e)
            {
                e.printStackTrace();
                response = e.getMessage();
                alert.setMessage(response).create();
                alert.show();
            }
            return null;
        }
        protected void onProgressUpdate(String... text)
        {
        }
        protected void onPostExecute(String result)
        {
        }
    }
}
