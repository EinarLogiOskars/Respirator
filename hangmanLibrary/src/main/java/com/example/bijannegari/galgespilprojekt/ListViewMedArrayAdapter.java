package com.example.bijannegari.galgespilprojekt;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.bijannegari.galgespilprojekt.HangmanMainActivity.logik;


public class ListViewMedArrayAdapter extends Fragment implements OnItemClickListener {

    ArrayList<String> muligeOrd = new ArrayList<>();
    private int numberOfWords = 100;
    static String chosenWord;
    static boolean manualWordChosen = false;
    Bundle b;
    int resid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_list_view_med_array_adapter, container, false);
        Bundle b = getArguments();
        resid = b.getInt("resid");

        numberOfWords = Math.min(100, logik.muligeOrd.size());
        for (int i = 0; i < numberOfWords; i++) {
            muligeOrd.add(i, logik.muligeOrd.get(i));
        }

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.activity_list_view_med_array_adapter, R.id.listeelem_overskrift, muligeOrd);

        ListView listView = new ListView(getActivity());
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);


        return listView;
    }


    public void onItemClick(AdapterView<?> liste, View v, int position, long id) {
        chosenWord = logik.muligeOrd.get(position);
        manualWordChosen = true;
        logik.nulstil();
        manualWordChosen = false;
        //finish();

        Fragment frag = new GalgeGame();
        frag.setArguments(getArguments());
        getFragmentManager().beginTransaction().replace(resid, frag).commit();
        //Intent intent = new Intent(this, GalgeGame.class);
        //startActivity(intent);
        //Toast.makeText(getActivity(), "Du har valgt ordet " + logik.muligeOrd.get(position), Toast.LENGTH_SHORT).show();
        // v vil pege på det LinearLayout der er roden i R.layout.lekt04_listeelement
        //Toast.makeText(this, " v = " + v, Toast.LENGTH_SHORT).show();
    }
}