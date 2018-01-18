/*
 * Created by bijannegari.
 */

package com.group5.respirator.Entertainment.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.group5.respirator.R;


public class ChessFragment extends Fragment {

    public ChessFragment() {
        // Required empty public constructor
    }

    public static ChessFragment newInstance() {
        return new ChessFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chess, container, false);
    }
}
