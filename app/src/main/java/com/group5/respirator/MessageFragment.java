package com.group5.respirator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MessageFragment extends Fragment implements View.OnClickListener
{
    private EditText Message;
    private Button EraseButton;

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

        Message = (EditText) view.findViewById(R.id.PatientMessage);
        EraseButton = (Button) view.findViewById(R.id.EraseButton);

        EraseButton.setOnClickListener(this);

        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onClick(View view)
    {
        Message.getText().clear();
    }
}
