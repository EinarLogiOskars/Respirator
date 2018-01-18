package com.group5.respirator.Communication.Fragments;
//Author Stuart Benjamin McLean s133018//
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.group5.respirator.R;

import java.util.ArrayList;


public class FeelingtStatusFragment extends Fragment implements View.OnClickListener {

    private Button questionbutton1;
    private Button questionbutton2;
    private Button questionbutton3;
    private Button questionbutton4;
    private Button questionbutton5;
    private Button questionbutton6;
    private Button questionbutton7;
    private Button questionbutton8;
    private Button questionbutton9;
    private Button questionbutton10;
    private Button questionbutton11;
    private Button questionbutton12;

    public static ArrayList<Button> FeelingButtonsCollection = new ArrayList<Button>();

    public FeelingtStatusFragment() {
        // Required empty public constructor
    }

    public static FeelingtStatusFragment newInstance() {
        FeelingtStatusFragment fragment = new FeelingtStatusFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FeelingButtonsCollection.add(questionbutton1 = view.findViewById(R.id.questionbutton1));
        FeelingButtonsCollection.add(questionbutton2 = view.findViewById(R.id.questionbutton2));
        FeelingButtonsCollection.add(questionbutton3 = view.findViewById(R.id.questionbutton3));
        FeelingButtonsCollection.add(questionbutton4 = view.findViewById(R.id.questionbutton4));
        FeelingButtonsCollection.add(questionbutton5 = view.findViewById(R.id.questionbutton5));
        FeelingButtonsCollection.add(questionbutton6 = view.findViewById(R.id.questionbutton6));
        FeelingButtonsCollection.add(questionbutton7 = view.findViewById(R.id.questionbutton7));
        FeelingButtonsCollection.add(questionbutton8 = view.findViewById(R.id.questionbutton8));
        FeelingButtonsCollection.add(questionbutton9 = view.findViewById(R.id.questionbutton9));
        FeelingButtonsCollection.add(questionbutton10 = view.findViewById(R.id.questionbutton10));
        FeelingButtonsCollection.add(questionbutton11 = view.findViewById(R.id.questionbutton11));
        FeelingButtonsCollection.add(questionbutton12 = view.findViewById(R.id.questionbutton12));

        questionbutton1.setOnClickListener(this);
        questionbutton2.setOnClickListener(this);
        questionbutton3.setOnClickListener(this);
        questionbutton4.setOnClickListener(this);
        questionbutton5.setOnClickListener(this);
        questionbutton6.setOnClickListener(this);
        questionbutton7.setOnClickListener(this);
        questionbutton8.setOnClickListener(this);
        questionbutton9.setOnClickListener(this);
        questionbutton10.setOnClickListener(this);
        questionbutton11.setOnClickListener(this);
        questionbutton12.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feelingt_status, container, false);
    }

    @Override
    public void onClick(View v)
    {
        if (v.isSelected() == false)
        {
            v.setSelected(true);
            v.getBackground().setColorFilter(new LightingColorFilter(Color.parseColor("#81858d"),0));
        } else
        {
            v.setSelected(false);
            v.getBackground().clearColorFilter();
        }
    }
}
