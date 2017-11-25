package com.group5.respirator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        InitialFragment intFrag = InitialFragment.newInstance();
        TouchFragment touchFrag = TouchFragment.newInstance();
        SoundFragment soundFrag = SoundFragment.newInstance();
        TextSizeFragment txtSizeFrag = TextSizeFragment.newInstance();
        LanguageFragment lngFrag = LanguageFragment.newInstance();


        getFragmentManager().beginTransaction().hide(touchFrag).commit();
        getFragmentManager().beginTransaction().hide(soundFrag).commit();
        getFragmentManager().beginTransaction().hide(txtSizeFrag).commit();
        getFragmentManager().beginTransaction().hide(lngFrag).commit();
        getFragmentManager().beginTransaction().show(intFrag).commit();



    }
}
