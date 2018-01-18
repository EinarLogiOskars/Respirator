/*
 * Created by bijannegari.
 */

package com.group5.respirator.Entertainment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.anup.tictactoe.Board;
import com.example.bijannegari.galgespilprojekt.HangmanMainActivity;
import com.group5.respirator.CallActivity;
import com.group5.respirator.Entertainment.Fragments.ChessFragment;
import com.group5.respirator.Entertainment.Fragments.MemoryFragment;
import com.group5.respirator.Entertainment.Fragments.QuizFragment;
import com.group5.respirator.Entertainment.Fragments.TicTacToeFragment;
import com.group5.respirator.R;

import org.tbadg.memory.MemoryActivity;


public class EntertainmentScreen extends AppCompatActivity implements View.OnClickListener {

    FragmentManager fragmentManager;

    QuizFragment quizFrag;
    TicTacToeFragment ticTacToeFrag;
    MemoryFragment memoryFrag;
    ChessFragment chessFrag;

    private Button callButton;
    private Button hangmanButton;
    private Button tictactoeButton;
    private Button memoryButton;

    private ImageView homeBtn;

    private TextView entertainmentTitle;



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

        callButton = findViewById(R.id.callButton);
        hangmanButton =  findViewById(R.id.hangmanButton);
        tictactoeButton =  findViewById(R.id.tictactoeButton);
        memoryButton = findViewById(R.id.memoryButton);
        homeBtn = findViewById(R.id.homeBtn);
        entertainmentTitle = findViewById(R.id.entertainmentTitle);

        hangmanButton.setOnClickListener(this);
        tictactoeButton.setOnClickListener(this);
        memoryButton.setOnClickListener(this);
        callButton.setOnClickListener(this);
        homeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == hangmanButton){
            int resid = R.id.fragment_container;
            Fragment f = new HangmanMainActivity();
            Bundle b = new Bundle();
            b.putInt("resid",resid);
            f.setArguments(b);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, f);
            fragmentTransaction.commit();
            if (entertainmentTitle.getVisibility() == View.VISIBLE ){
                entertainmentTitle.setVisibility(View.GONE);
            }
        }

        else if (view == tictactoeButton){
            int resid = R.id.fragment_container;
            Fragment f = new Board();
            Bundle b = new Bundle();
            b.putInt("resid",resid);
            f.setArguments(b);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, f);
            fragmentTransaction.commit();
            if (entertainmentTitle.getVisibility() == View.VISIBLE ){
                entertainmentTitle.setVisibility(View.GONE);
            }
        }
        else if (view == memoryButton){
            Intent Intent = new Intent(this, MemoryActivity.class);
            startActivity(Intent);
            if (entertainmentTitle.getVisibility() == View.VISIBLE ){
                entertainmentTitle.setVisibility(View.GONE);
            }
        }
        else if (view == callButton){
            Intent callIntent = new Intent(this,CallActivity.class);
            startActivity(callIntent);
            if (entertainmentTitle.getVisibility() == View.VISIBLE ){
                entertainmentTitle.setVisibility(View.GONE);
            }
        }
        else if (view == homeBtn){
            finish();
        }
    }
}