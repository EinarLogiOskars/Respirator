package com.example.bijannegari.galgespilprojekt;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import static com.example.bijannegari.galgespilprojekt.ListViewMedArrayAdapter.chosenWord;
import static com.example.bijannegari.galgespilprojekt.ListViewMedArrayAdapter.manualWordChosen;
import static com.example.bijannegari.galgespilprojekt.MainActivity.logik;

public class GalgeGame extends AppCompatActivity implements View.OnClickListener {

    Random random = new Random();

    MediaPlayer sound_lose1;
    MediaPlayer sound_lose2;
    MediaPlayer sound_lose3;
    MediaPlayer sound_lose4;
    MediaPlayer sound_win1;
    MediaPlayer sound_win2;
    MediaPlayer sound_win3;
    MediaPlayer sound_win4;

    private Button buttonGuess;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private EditText bogstavGuess;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galge_game);

        sound_lose1 = MediaPlayer.create(this, R.raw.sound_lose1);
        sound_lose2 = MediaPlayer.create(this, R.raw.sound_lose2);
        sound_lose3 = MediaPlayer.create(this, R.raw.sound_lose3);
        sound_lose4 = MediaPlayer.create(this, R.raw.sound_lose4);
        sound_win1 = MediaPlayer.create(this, R.raw.sound_win1);
        sound_win2 = MediaPlayer.create(this, R.raw.sound_win2);
        sound_win3 = MediaPlayer.create(this, R.raw.sound_win3);
        sound_win4 = MediaPlayer.create(this, R.raw.sound_win4);

        buttonGuess = (Button) findViewById(R.id.buttonGuess);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        bogstavGuess = (EditText) findViewById(R.id.bogstavGuess);
        imageView = (ImageView) findViewById(R.id.imageView);


        startGame();
    }


    public void startGame() {

        textView1.setText(logik.getSynligtOrd());
        buttonGuess.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String guess = bogstavGuess.getText().toString();
        logik.gætBogstav(guess);

        if (logik.erSidsteBogstavKorrekt() == true) {
            textView3.setText("Korrekt bogstav: " + guess);
            bogstavGuess.setText("");
            textView1.setText(logik.getSynligtOrd());
            textView2.setText(logik.getBrugteBogstaver().toString());

            if (logik.erSpilletVundet() == true) {
                randomSoundwin();
                finish();
                Intent intent1 = new Intent(this, GameOver.class);
                startActivity(intent1);

            }
        } else {
            textView3.setText("Forkert bogstav: " + guess);
            bogstavGuess.setText("");
            textView2.setText(logik.getBrugteBogstaver().toString());

            if (logik.getAntalForkerteBogstaver() == 1) {
                imageView.setImageResource(R.drawable.forkert1);
            } else if (logik.getAntalForkerteBogstaver() == 2) {
                imageView.setImageResource(R.drawable.forkert2);
            } else if (logik.getAntalForkerteBogstaver() == 3) {
                imageView.setImageResource(R.drawable.forkert3);
            } else if (logik.getAntalForkerteBogstaver() == 4) {
                imageView.setImageResource(R.drawable.forkert4);
            } else if (logik.getAntalForkerteBogstaver() == 5) {
                imageView.setImageResource(R.drawable.forkert5);
            } else if (logik.getAntalForkerteBogstaver() == 6) {
                imageView.setImageResource(R.drawable.forkert6);
            } else {
                randomSoundLose();
                finish();
                Intent intent1 = new Intent(this, GameOver.class);
                startActivity(intent1);
            }
        }
    }

    public void randomSoundLose() {
        if (random.nextInt(4) == 1) {
            sound_lose1.start();
        } else if (random.nextInt(4) == 2) {
            sound_lose2.start();
        } else if (random.nextInt(4) == 3) {
            sound_lose3.start();
        } else {
            sound_lose4.start();
        }
    }
    public void randomSoundwin() {
        if (random.nextInt(4) == 1) {
            sound_win1.start();
        } else if (random.nextInt(4) == 2) {
            sound_win2.start();
        } else if (random.nextInt(4) == 3) {
            sound_win3.start();
        } else {
            sound_win4.start();
        }
    }
}
