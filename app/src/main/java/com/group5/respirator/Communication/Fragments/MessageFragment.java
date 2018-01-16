package com.group5.respirator.Communication.Fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.group5.respirator.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class MessageFragment extends Fragment implements View.OnClickListener
{
    private EditText Message;
    private Button EraseButton;
    private Button PostButton;
    private SharedPreferences pref;
    private String MessageSend;
    private String Time;
    private ListView show;
    private List<String> MessageOut;
    private ArrayAdapter<String> arrayAdapter;

    public static final String SharedPrefName = "MinPref";

    public MessageFragment()
    {
        // Required empty public constructor
    }

    public static MessageFragment newInstance()
    {
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        return inflater.inflate(R.layout.fragment_message, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Message = (EditText) view.findViewById(R.id.PatientMessage);
        show = (ListView) view.findViewById(R.id.DisplayMessage);

        EraseButton = (Button) view.findViewById(R.id.EraseButton);
        PostButton = (Button) view.findViewById(R.id.PostButton);

        PostButton.setOnClickListener(this);
        EraseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view == PostButton)
        {
            QuickTapButton(view);
            Time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            MessageSend = ("["+ Time + "]" + " " +  Message.getText().toString());

            pref = getActivity().getSharedPreferences(SharedPrefName, MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putInt("id", pref.getInt("id",0)+1);
            editor.putString("Message"+pref.getInt("id", 0), MessageSend);
            editor.commit();
        }
        else if(view == EraseButton)
        {
            QuickTapButton(view);
            SharedPreferences.Editor editor = pref.edit();
            editor.clear().commit();
        }

        DisplayMessage();
        Message.setText("");
    }
    public void DisplayMessage()
    {
        MessageOut = new ArrayList<>();

        for(int i=0; i< pref.getInt("id",0); i++)
        {
            MessageOut.add(i, pref.getString("Message"+i,"No name defined"));
        }

        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, MessageOut);
        show.setAdapter(arrayAdapter);
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