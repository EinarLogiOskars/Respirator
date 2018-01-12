package com.example.bijannegari.galgespilprojekt;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static com.example.bijannegari.galgespilprojekt.HangmanMainActivity.logik;

public class ChooseWordManually extends Fragment implements View.OnClickListener{

    private Button jaButton;
    private Button nejButton;
    int resid;
    Bundle b;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_choose_word_manually, container, false);
        b = getArguments();
        resid = b.getInt("resid");

        jaButton = (Button) v.findViewById(R.id.jaButton);
        nejButton = (Button) v.findViewById(R.id.nejButton);

        jaButton.setOnClickListener(this);
        nejButton.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View view) {
        if(view == jaButton){
        // finish();
            Fragment frag = new ListViewMedArrayAdapter();
            frag.setArguments(b);
            getFragmentManager().beginTransaction().replace(resid, frag).commit();

            //  Intent intent = new Intent(this, ListViewMedArrayAdapter.class);
            //  startActivity(intent);
        }

        else if(view == nejButton){
            // finish();
            Fragment frag = new GalgeGame();
            frag.setArguments(b);
            logik.nulstil();
            getFragmentManager().beginTransaction().replace(resid, frag).commit();

            // getFragmentManager().beginTransaction().replace(resid, new GalgeGame());
            //Intent intent = new Intent(this, GalgeGame.class);
           // startActivity(intent);
        }
    }
}
