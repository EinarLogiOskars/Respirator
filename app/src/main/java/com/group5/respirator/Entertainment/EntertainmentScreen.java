package com.group5.respirator.Entertainment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.group5.respirator.Entertainment.Fragments.ChessFragment;
import com.group5.respirator.Entertainment.Fragments.MemoryFragment;
import com.group5.respirator.Entertainment.Fragments.QuizFragment;
import com.group5.respirator.Entertainment.Fragments.TicTacToeFragment;
import com.group5.respirator.R;

public class EntertainmentScreen extends AppCompatActivity implements View.OnClickListener {

    FragmentManager fragmentManager;

    QuizFragment quizFrag;
    TicTacToeFragment ticTacToeFrag;
    MemoryFragment memoryFrag;
    ChessFragment chessFrag;

    private Button callButton;
    private Button ticTacToeBtn;
    private Button quizBtn;
    private Button memoryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_entertainment_screen);

        fragmentManager = getSupportFragmentManager();

        quizFrag = QuizFragment.newInstance();
        ticTacToeFrag = TicTacToeFragment.newInstance();
        memoryFrag = MemoryFragment.newInstance();
        chessFrag = ChessFragment.newInstance();

        callButton = (Button) findViewById(R.id.callButton);
        ticTacToeBtn = (Button) findViewById(R.id.ticTacToeBtn);
        quizBtn = (Button) findViewById(R.id.quizBtn);
        memoryBtn = (Button) findViewById(R.id.memoryBtn);

        ticTacToeBtn.setOnClickListener(this);
        quizBtn.setOnClickListener(this);
        memoryBtn.setOnClickListener(this);
        callButton.setOnClickListener(this);
    }

    public void openQuiz(View view) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, quizFrag);
        fragmentTransaction.commit();

    }

    public void openTicTacToe(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, ticTacToeFrag);
        fragmentTransaction.commit();
    }


    public void openMemoryGame(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, memoryFrag);
        fragmentTransaction.commit();
    }

    public void openChessGame(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, chessFrag);
        fragmentTransaction.commit();
    }

    public void home(View view) {

        finish();
    }

    @Override
    public void onClick(View view) {
        if (view == ticTacToeBtn){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, ticTacToeFrag);
            fragmentTransaction.commit();
        }
        else if (view == quizBtn){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, quizFrag);
            fragmentTransaction.commit();
        }
        else if (view == memoryBtn){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, memoryFrag);
            fragmentTransaction.commit();
        }
        else if (view == callButton){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            // Setting Alert Dialog Title
            alertDialogBuilder.setTitle("Konfirmer kald!!!");

            // Icon Of Alert Dialog. Har bare valgt et tilfældigt billed, det ændrer vi
//            alertDialogBuilder.setIcon(R.drawable.thumbs);

            // Setting Alert Dialog Message
            alertDialogBuilder.setMessage("Are you sure, You want to call?");

            // Man kan cancel alertDialog ved at trykke uden for boksen
            alertDialogBuilder.setCancelable(true);

            alertDialogBuilder.setPositiveButton("Kald!", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface arg0, int arg1) {
                    finish();
                }
            });

            alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"You clicked on Cancel",Toast.LENGTH_SHORT).show();
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }
}