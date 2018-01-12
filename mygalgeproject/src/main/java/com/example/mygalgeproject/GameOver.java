package com.example.bijannegari.galgespilprojekt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.Serializable;
import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

import static com.example.bijannegari.galgespilprojekt.MainActivity.logik;


public class GameOver extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView2;
    private TextView textView5;
    private TextView textView4;
    private Button spilIgenButton;
    private Button homeScreenButton;
    private Button submitHighscoreButton;
    private EditText editTextSpillerNavn;
    private String spillerNavn;
    public static String highscore;
    KonfettiView konfettiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        konfettiView = (KonfettiView) findViewById(R.id.viewKonfetti);

        imageView2 = (ImageView) findViewById(R.id.imageView2);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        spilIgenButton = (Button) findViewById(R.id.spilIgenButton);
        homeScreenButton = (Button) findViewById(R.id.homeScreenButton);
        submitHighscoreButton = (Button) findViewById(R.id.submitHighscoreButton);
        editTextSpillerNavn = (EditText) findViewById(R.id.editTextSpillerNavn);


        spilIgenButton.setOnClickListener(this);
        homeScreenButton.setOnClickListener(this);
        submitHighscoreButton.setOnClickListener(this);


        if (logik.erSpilletVundet() == true) {
            buildKonfetti();
            imageView2.setImageResource(R.drawable.happy_smiley);
            textView4.setText("Godt lavet G, du gættede ordet: " + logik.getOrdet());
            textView5.setText("Du brugte " + logik.getAntalForkerteBogstaver() + " forsøg");

        }
        else if (logik.erSpilletTabt() == true) {
            imageView2.setImageResource(R.drawable.sad_smiley);
            textView4.setText("Bekalger G, du har tabt");
            textView5.setText("Det rigtige ord var: " + logik.getOrdet());
            submitHighscoreButton.setVisibility(View.GONE);
            editTextSpillerNavn.setVisibility(View.GONE);
        }
    }

    public void onClick(View view) {
        if (view == spilIgenButton) {
            finish();
            Intent intent = new Intent(this, ChooseWordManually.class);
            startActivity(intent);
        } else if (view == homeScreenButton) {
            finish();
            // Intent intent = new Intent(this, MainActivity.class);
            // startActivity(intent);
        }
        else if (view == submitHighscoreButton){
            // Bruges som reference for at se hvor mange forsøg der er blevet brugt

            spillerNavn = editTextSpillerNavn.getText().toString();
            String spillerScore = "\t" + spillerNavn + " " + logik.getAntalForkerteBogstaver() + " forsøg brugt.";
            SharedPreferences sharedpreferences = getSharedPreferences(highscore, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putInt("id", sharedpreferences.getInt("id",0)+1);
            editor.putString("spillerNavn"+sharedpreferences.getInt("id", 0), spillerScore);
            editor.commit();

            finish();
            Intent i = new Intent(this, Highscore.class);
            startActivity(i);
        }
    }

    private void buildKonfetti(){
        konfettiView.build()
                .addColors(Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.BLACK)
                .setDirection(0.0,359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(12,5f))
                .setPosition(640f, (float) konfettiView.getWidth() + 50f, 0f, -150f)
                .stream(100, 4000L);
    }
}
