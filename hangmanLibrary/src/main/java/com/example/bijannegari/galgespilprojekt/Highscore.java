package com.example.bijannegari.galgespilprojekt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Highscore extends Fragment implements View.OnClickListener {

    private ListView listView;

    private List<String> spillerScore;

    private ArrayAdapter arrayAdapter;

    private SharedPreferences pref;

    private Button button3;
    private Button button4;
    private Button clearHighscoreListButton;
    Bundle b;
    int resid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_highscore, container, false);
        b = getArguments();
        resid = b.getInt("resid");

        listView = (ListView) v.findViewById(R.id.listView);

        button3 = (Button) v.findViewById(R.id.button3);
        button4 = (Button) v.findViewById(R.id.button4);
        clearHighscoreListButton = (Button) v.findViewById(R.id.clearHighscoreListButton);

        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        clearHighscoreListButton.setOnClickListener(this);

        pref = getActivity().getSharedPreferences(GameOver.highscore, MODE_PRIVATE);

        showHighscore();
        return v;
    }

    public void showHighscore()
    {

        spillerScore = new ArrayList<>();
        for(int i = 0; i < pref.getInt("id",0); i++)
        {
            spillerScore.add(i, pref.getString("spillerNavn" + i, "okgpkeog defined"));
        }
        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, spillerScore);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view == button3){
            Fragment frag = new ChooseWordManually();
            frag.setArguments(b);
            getFragmentManager().beginTransaction().replace(resid, frag).commit();
            //Intent intent = new Intent(this, ChooseWordManually.class);
           // startActivity(intent);
        }
        else if (view == button4){
            Fragment frag = new HangmanMainActivity();
            frag.setArguments(b);
            getFragmentManager().beginTransaction().replace(resid, frag).commit();
        }
        else if (view == clearHighscoreListButton){
            SharedPreferences.Editor editor = pref.edit();
            editor.clear().commit();
            showHighscore();
        }
    }
}
