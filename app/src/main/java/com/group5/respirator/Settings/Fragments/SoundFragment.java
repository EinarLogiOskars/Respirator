package com.group5.respirator.Settings.Fragments;


import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.group5.respirator.Preferences;
import com.group5.respirator.R;

/*
 * Created by Einar Logi Óskarsson.
 */

public class SoundFragment extends Fragment implements View.OnClickListener {

    AudioManager audioManager;

    public SoundFragment() {
        // Required empty public constructor
    }


    public static SoundFragment newInstance() {
        return new SoundFragment();
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
        return inflater.inflate(R.layout.fragment_sound, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);

        Button upButton = (Button) getView().findViewById(R.id.maxVolBtn);
        upButton.setOnClickListener(this);

        Button downButton = (Button) getView().findViewById(R.id.midVolBtn);
        downButton.setOnClickListener(this);

        Button muteButton = (Button) getView().findViewById(R.id.muteBtn);
        muteButton.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.maxVolBtn:
                audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
                break;
            case R.id.midVolBtn:
                audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
                break;
            case R.id.muteBtn:
                audioManager.adjustVolume(AudioManager.ADJUST_TOGGLE_MUTE, AudioManager.FLAG_PLAY_SOUND);
                break;
        }
    }

}
