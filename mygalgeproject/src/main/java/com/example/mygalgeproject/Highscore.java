package com.example.bijannegari.galgespilprojekt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

import java.util.List;

public class Highscore extends AppCompatActivity implements View.OnClickListener {

    private ListView listView;

    private List<String> spillerScore;

    private ArrayAdapter<String> arrayAdapter;

    private SharedPreferences pref;

    private Button button3;
    private Button button4;
    private Button clearHighscoreListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        listView = (ListView) findViewById(R.id.listView);

        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        clearHighscoreListButton = (Button) findViewById(R.id.clearHighscoreListButton);

        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        clearHighscoreListButton.setOnClickListener(this);

        pref = getSharedPreferences(GameOver.highscore, MODE_PRIVATE);

        showHighscore();
    }

    public void showHighscore()
    {

        spillerScore = new ArrayList<>();
        for(int i = 0; i < pref.getInt("id",0); i++)
        {
            spillerScore.add(i, pref.getString("spillerNavn" + i, "okgpkeog defined"));
        }
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spillerScore);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view == button3){
            finish();
            Intent intent = new Intent(this, ChooseWordManually.class);
            startActivity(intent);
        }
        else if (view == button4){
            finish();
        }
        else if (view == clearHighscoreListButton){
            SharedPreferences.Editor editor = pref.edit();
            editor.clear().commit();
            showHighscore();
        }
    }
}
