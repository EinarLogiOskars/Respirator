package com.group5.respirator.Entertainment.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.group5.respirator.R;


public class MemoryFragment extends Fragment {

    public MemoryFragment() {
        // Required empty public constructor
    }


    public static MemoryFragment newInstance() {
        MemoryFragment fragment = new MemoryFragment();
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
        return inflater.inflate(R.layout.fragment_memory, container, false);
    }


}
