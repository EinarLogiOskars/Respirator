package com.example.bijannegari.galgespilprojekt;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;

public class HangmanMainActivity extends Fragment implements View.OnClickListener {


    static Galgelogik logik = new Galgelogik();

    private Button button1;
    private Button button2;
    private Button highscoreButton;
    int resid;
    Bundle b;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.hangman_activity_main, container, false);
        b = getArguments();
        resid = b.getInt("resid");

        button1 = (Button) v.findViewById(R.id.button1);
        button2 = (Button) v.findViewById(R.id.button2);
        highscoreButton = (Button) v.findViewById(R.id.highscoreButton);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        highscoreButton.setOnClickListener(this);

        new AsyncTaskRunner().execute();

        return v;
    }




    @Override
    public void onClick(View view) {
        if (view == button1){
            Fragment choose = new ChooseWordManually();
            Log.d("xxxx", "posB  b er "+b);
            choose.setArguments(b);
            getFragmentManager().beginTransaction().replace(resid, choose).commit();
            //Intent intent = new Intent(this, ChooseWordManually.class);
            //startActivity(intent);
        }
        else if(view == button2){
            // finish();
        }
        else if(view == highscoreButton){
            //Intent intent = new Intent(this, Highscore.class);
            //startActivity(intent);
        }
    }


    private class AsyncTaskRunner extends AsyncTask<String, String, String>
    {
        private String response;
        //  final AlertDialog.Builder alert = new AlertDialog.Builder(HangmanMainActivity.this);

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
                // alert.setMessage(response).create();
                // alert.show();
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
