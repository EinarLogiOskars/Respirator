package com.example.bijannegari.galgespilprojekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.bijannegari.galgespilprojekt.MainActivity.logik;


public class ListViewMedArrayAdapter extends AppCompatActivity implements OnItemClickListener {

    ArrayList<String> muligeOrd = new ArrayList<>();
    private int numberOfWords = 100;
    static String chosenWord;
    static boolean manualWordChosen = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i = 0; i < numberOfWords; i++){
            muligeOrd.add(i, logik.muligeOrd.get(i));
        }

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.activity_list_view_med_array_adapter, R.id.listeelem_overskrift, muligeOrd);

        ListView listView = new ListView(this);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

        setContentView(listView);
    }

    public void onItemClick(AdapterView<?> liste, View v, int position, long id) {
        chosenWord = logik.muligeOrd.get(position);
        manualWordChosen = true;
        logik.nulstil();
        manualWordChosen = false;
        finish();
        Intent intent = new Intent(this, GalgeGame.class);
        startActivity(intent);
        Toast.makeText(this, "Du har valgt ordet " + logik.muligeOrd.get(position), Toast.LENGTH_SHORT).show();
        // v vil pege på det LinearLayout der er roden i R.layout.lekt04_listeelement
        //Toast.makeText(this, " v = " + v, Toast.LENGTH_SHORT).show();
    }
}