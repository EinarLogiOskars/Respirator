package com.group5.respirator.Communication.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.group5.respirator.R;


public class FeelingtStatusFragment extends Fragment {

    public FeelingtStatusFragment()
    {
        // Required empty public constructor
    }

    public static FeelingtStatusFragment newInstance()
    {
        FeelingtStatusFragment fragment = new FeelingtStatusFragment();
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
        return inflater.inflate(R.layout.fragment_feelingt_status, container, false);
    }
}
