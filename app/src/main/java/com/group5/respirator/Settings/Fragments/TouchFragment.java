package com.group5.respirator.Settings.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.group5.respirator.Preferences;
import com.group5.respirator.R;


public class TouchFragment extends Fragment {


    public TouchFragment() {
        // Required empty public constructor
    }


    public static TouchFragment newInstance() {
        return new TouchFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getActivity().getTheme().applyStyle(new Preferences(getContext()).getFontStyle().getResId(), true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_touch, container, false);
    }

}
