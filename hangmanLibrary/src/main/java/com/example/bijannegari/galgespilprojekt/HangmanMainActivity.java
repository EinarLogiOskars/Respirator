package com.example.bijannegari.galgespilprojekt;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HangmanMainActivity extends Fragment implements View.OnClickListener {

    static Galgelogik logik = new Galgelogik();

    private Button button1;
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

        button1 = v.findViewById(R.id.button1);
        highscoreButton = v.findViewById(R.id.highscoreButton);

        button1.setOnClickListener(this);
        highscoreButton.setOnClickListener(this);

        new AsyncTaskRunner().execute();

        return v;
    }




    @Override
    public void onClick(View view) {
        if (view == button1){
            Fragment frag = new ChooseWordManually();
            frag.setArguments(b);
            getFragmentManager().beginTransaction().replace(resid, frag).commit();
        }

        else if(view == highscoreButton){
            Fragment frag = new Highscore();
            frag.setArguments(b);
            getFragmentManager().beginTransaction().replace(resid, frag).commit();
        }
    }


    // @SuppressLint("StaticFieldLeak")
    private class AsyncTaskRunner extends AsyncTask<String, String, String>
    {
        private String response;

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
