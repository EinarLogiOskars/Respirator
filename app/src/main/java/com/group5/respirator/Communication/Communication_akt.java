package com.group5.respirator.Communication;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.group5.respirator.R;


public class Communication_akt extends AppCompatActivity
{

    ActionsFragment ActionFrag;
    DisplayPainFragment DisplayPainFrag;
    FeelingtStatusFragment FeelingFrag;
    MessageFragment MessageFrag;
    QuestionFragment QuestionFrag;
    FragmentManager fragmentManager;
    TextView textView1;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        fragmentManager = getSupportFragmentManager();
        ActionFrag = ActionsFragment.newInstance();
        DisplayPainFrag = DisplayPainFragment.newInstance();
        FeelingFrag = FeelingtStatusFragment.newInstance();
        MessageFrag = MessageFragment.newInstance();
        QuestionFrag = QuestionFragment.newInstance();

        textView1 = (TextView) findViewById(R.id.title1);

    }

    public void DisplayActionFrag(View view)
    {

        if (textView1.getVisibility() == View.VISIBLE)
        {
            textView1.setVisibility(View.GONE);
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, ActionFrag);
        fragmentTransaction.commit();
    }
    public void DisplayPainFrag(View view)
    {

        if (textView1.getVisibility() == View.VISIBLE)
        {
            textView1.setVisibility(View.GONE);
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, DisplayPainFrag);
        fragmentTransaction.commit();
    }
    public void DisplayFeelingFrag(View view)
    {
        if (textView1.getVisibility() == View.VISIBLE)
        {
            textView1.setVisibility(View.GONE);
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, FeelingFrag);
        fragmentTransaction.commit();
    }
    public void DisplayMessageFrag(View view) {

        if (textView1.getVisibility() == View.VISIBLE)
        {
            textView1.setVisibility(View.GONE);
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, MessageFrag);
        fragmentTransaction.commit();
    }
    public void DisplayQuestionFrag(View view)
    {
        if (textView1.getVisibility() == View.VISIBLE)
        {
            textView1.setVisibility(View.GONE);
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, QuestionFrag);
        fragmentTransaction.commit();
    }

    public void home(View view)
    {
        finish();
    }

}
