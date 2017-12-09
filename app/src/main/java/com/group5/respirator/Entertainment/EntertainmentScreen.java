package com.group5.respirator.Entertainment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

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

        ticTacToeBtn = (Button) findViewById(R.id.ticTacToeBtn);
        quizBtn = (Button) findViewById(R.id.quizBtn);
        memoryBtn = (Button) findViewById(R.id.memoryBtn);

        ticTacToeBtn.setOnClickListener(this);
        quizBtn.setOnClickListener(this);
        memoryBtn.setOnClickListener(this);

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
    }
}