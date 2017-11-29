package com.group5.respirator;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Communication_akt extends AppCompatActivity
{

    ActionsFragment ActionFrag;
    DisplayPainFragment DisplayPainFrag;
    FeelingtStatusFragment FeelingFrag;
    MessageFragment MessageFrag;
    QuestionFragment QuestionFrag;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);



    }
}
