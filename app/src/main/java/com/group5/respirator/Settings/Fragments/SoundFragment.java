package com.group5.respirator.Settings.Fragments;


import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.group5.respirator.R;


public class SoundFragment extends Fragment implements View.OnClickListener {

    AudioManager audioManager;

    public SoundFragment() {
        // Required empty public constructor
    }


    public static SoundFragment newInstance() {
        SoundFragment fragment = new SoundFragment();
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
        return inflater.inflate(R.layout.fragment_sound, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);

        Button upButton = (Button) getView().findViewById(R.id.raiseVolBtn);
        upButton.setOnClickListener(this);

        Button downButton = (Button) getView().findViewById(R.id.lowerVolBtn);
        downButton.setOnClickListener(this);

        Button muteButton = (Button) getView().findViewById(R.id.muteBtn);
        muteButton.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.raiseVolBtn:
                audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
                break;
            case R.id.lowerVolBtn:
                audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
                break;
            case R.id.muteBtn:
                audioManager.adjustVolume(AudioManager.ADJUST_TOGGLE_MUTE, AudioManager.FLAG_PLAY_SOUND);
                break;
        }
    }
}
