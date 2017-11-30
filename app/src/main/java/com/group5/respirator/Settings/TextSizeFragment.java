package com.group5.respirator.Settings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.group5.respirator.R;


public class TextSizeFragment extends Fragment {


    public TextSizeFragment() {
        // Required empty public constructor
    }


    public static TextSizeFragment newInstance() {
        TextSizeFragment fragment = new TextSizeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text_size, container, false);
    }

}
