package com.example.bijannegari.galgespilprojekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.bijannegari.galgespilprojekt.MainActivity.logik;

public class ChooseWordManually extends AppCompatActivity implements View.OnClickListener{

    private Button jaButton;
    private Button nejButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_word_manually);

        jaButton = (Button) findViewById(R.id.jaButton);
        nejButton = (Button) findViewById(R.id.nejButton);

        jaButton.setOnClickListener(this);
        nejButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == jaButton){
        finish();
        Intent intent = new Intent(this, ListViewMedArrayAdapter.class);
        startActivity(intent);
        }
        else if(view == nejButton){
            finish();
            logik.nulstil();
            Intent intent = new Intent(this, GalgeGame.class);
            startActivity(intent);
        }
    }
}
