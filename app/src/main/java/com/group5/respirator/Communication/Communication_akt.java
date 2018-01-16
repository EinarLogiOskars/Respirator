package com.group5.respirator.Communication;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.group5.respirator.Communication.Fragments.ActionsFragment;
import com.group5.respirator.Communication.Fragments.DisplayPainFragment;
import com.group5.respirator.Communication.Fragments.FeelingtStatusFragment;
import com.group5.respirator.Communication.Fragments.MessageFragment;
import com.group5.respirator.Communication.Fragments.QuestionFragment;
import com.group5.respirator.R;

import java.util.ArrayList;
import java.util.List;

public class Communication_akt extends AppCompatActivity implements View.OnClickListener
{
    private ActionsFragment ActionFrag;
    private DisplayPainFragment DisplayPainFrag;
    private FeelingtStatusFragment FeelingFrag;
    private MessageFragment MessageFrag;
    private QuestionFragment QuestionFrag;
    private FragmentManager fragmentManager;
    private TextView textView1;
    private Button Messagebutton;
    private Button PainButton;
    private Button FeelingButton;
    private Button QuestionButton;
    private Button ActionsButton;
    private Button HomeButton;

    private ArrayList<Button> ButtonsCollection = new ArrayList<Button>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_communication);

        fragmentManager = getSupportFragmentManager();
        ActionFrag = ActionsFragment.newInstance();
        DisplayPainFrag = DisplayPainFragment.newInstance();
        FeelingFrag = FeelingtStatusFragment.newInstance();
        MessageFrag = MessageFragment.newInstance();
        QuestionFrag = QuestionFragment.newInstance();

        textView1 = (TextView) findViewById(R.id.title1);
        Messagebutton = (Button) findViewById(R.id.button2);
        PainButton = (Button) findViewById(R.id.button3);
        FeelingButton = (Button) findViewById(R.id.button4);
        QuestionButton = (Button) findViewById(R.id.button5);
        ActionsButton = (Button) findViewById(R.id.button6);
        HomeButton = (Button) findViewById(R.id.button8);

        ButtonsCollection.add(Messagebutton);
        ButtonsCollection.add(PainButton);
        ButtonsCollection.add(FeelingButton);
        ButtonsCollection.add(QuestionButton);
        ButtonsCollection.add(ActionsButton);

        Messagebutton.setOnClickListener(this);
        PainButton.setOnClickListener(this);
        FeelingButton.setOnClickListener(this);
        QuestionButton.setOnClickListener(this);
        ActionsButton.setOnClickListener(this);
        HomeButton.setOnClickListener(this);
    }

    public void DisplayActionFrag()
    {
        ButtonCleaner(ActionsButton);

        if (ActionsButton.isSelected() == false)
        {
            ActionsButton.setSelected(true);
            ActionsButton.getBackground().setColorFilter(new LightingColorFilter(Color.parseColor("#81858d"),0));

        } else
        {
            QuickTapButton(ActionsButton);
        }

        if (textView1.getVisibility() == View.VISIBLE)
        {
            textView1.setVisibility(View.GONE);
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, ActionFrag);
        fragmentTransaction.commit();
    }
    public void DisplayPainFrag()
    {
        ButtonCleaner(PainButton);

        if (PainButton.isSelected() == false)
        {
            PainButton.setSelected(true);
            PainButton.getBackground().setColorFilter(new LightingColorFilter(Color.parseColor("#81858d"),0));

        } else
        {
            QuickTapButton(PainButton);
        }

        if (textView1.getVisibility() == View.VISIBLE)
        {
            textView1.setVisibility(View.GONE);
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, DisplayPainFrag);
        fragmentTransaction.commit();
    }
    public void DisplayFeelingFrag()
    {
        ButtonCleaner(FeelingButton);

        if (FeelingButton.isSelected() == false)
        {
            FeelingButton.setSelected(true);
            FeelingButton.getBackground().setColorFilter(new LightingColorFilter(Color.parseColor("#81858d"),0));

        } else
        {
            QuickTapButton(FeelingButton);
        }

        if (textView1.getVisibility() == View.VISIBLE)
        {
            textView1.setVisibility(View.GONE);
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, FeelingFrag);
        fragmentTransaction.commit();
    }
    public void DisplayMessageFrag()
    {
        ButtonCleaner(Messagebutton);

        if (Messagebutton.isSelected() == false)
        {
            Messagebutton.setSelected(true);
            Messagebutton.getBackground().setColorFilter(new LightingColorFilter(Color.parseColor("#81858d"),0));

        } else
        {
            QuickTapButton(Messagebutton);
        }

        if (textView1.getVisibility() == View.VISIBLE)
        {
            textView1.setVisibility(View.GONE);
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, MessageFrag);
        fragmentTransaction.commit();
    }

    public void DisplayQuestionFrag()
    {
        ButtonCleaner(QuestionButton);


        if (QuestionButton.isSelected() == false)
        {
            QuestionButton.setSelected(true);
            QuestionButton.getBackground().setColorFilter(new LightingColorFilter(Color.parseColor("#81858d"),0));
        }
        else
        {
            QuickTapButton(QuestionButton);
        }

        if (textView1.getVisibility() == View.VISIBLE)
        {
            textView1.setVisibility(View.GONE);
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, QuestionFrag);
        fragmentTransaction.commit();
    }

    public void Home()
    {
        for (int i = 0; i < ButtonsCollection.size(); i++)
        {
            ButtonsCollection.get(i).getBackground().clearColorFilter();
            ButtonsCollection.get(i).setSelected(false);
        }
        finish();
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.button2:
                DisplayMessageFrag();
                break;
            case R.id.button3:
                DisplayPainFrag();
                break;
            case R.id.button4:
                DisplayFeelingFrag();
                break;
            case R.id.button5:
                DisplayQuestionFrag();
                break;
            case R.id.button6:
                DisplayActionFrag();
                break;
            case R.id.button8:
                Home();
                break;
            default:
                break;
        }
    }

    public void ButtonCleaner(Button b)
    {
        for (int i = 0; i < ButtonsCollection.size(); i++)
        {
            if(b.getId() != ButtonsCollection.get(i).getId())
            {
                ButtonsCollection.get(i).getBackground().clearColorFilter();
                ButtonsCollection.get(i).setSelected(false);
            }
        }
    }
    public void QuickTapButton(View v)
    {
        AlphaAnimation alphaDown = new AlphaAnimation(1.0f, 0.3f);
        AlphaAnimation alphaUp = new AlphaAnimation(0.3f, 1.0f);
        alphaDown.setDuration(1000);
        alphaUp.setDuration(500);
        alphaDown.setFillAfter(true);
        alphaUp.setFillAfter(true);
        v.startAnimation(alphaUp);
    }
}

