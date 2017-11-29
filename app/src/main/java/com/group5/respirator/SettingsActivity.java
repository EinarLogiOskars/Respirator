package com.group5.respirator;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    TouchFragment touchFrag;
    SoundFragment soundFrag;
    TextSizeFragment textSizeFrag;
    LanguageFragment langFrag;
    FragmentManager fragmentManager;

    TextView textView1;
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        fragmentManager = getSupportFragmentManager();
        touchFrag = TouchFragment.newInstance();
        soundFrag = SoundFragment.newInstance();
        textSizeFrag = TextSizeFragment.newInstance();
        langFrag = LanguageFragment.newInstance();

        textView1 = (TextView) findViewById(R.id.title1);
        textView2 = (TextView) findViewById(R.id.title2);
        textView3 = (TextView) findViewById(R.id.title3);

    }

    /*
    This function displays the touch setting fragment when you click the touch setting button.
    The original function call is created in the xml declaration for the button in activity_settings.xml
     */
    public void touchSettings(View view) {

        if (textView1.getVisibility() == View.VISIBLE) {
            textView1.setVisibility(View.GONE);
            textView2.setVisibility(View.GONE);
            textView3.setVisibility(View.GONE);
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, touchFrag);
        fragmentTransaction.commit();

    }

    public void sound(View view) {

        if (textView1.getVisibility() == View.VISIBLE) {
            textView1.setVisibility(View.GONE);
            textView2.setVisibility(View.GONE);
            textView3.setVisibility(View.GONE);
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, soundFrag);
        fragmentTransaction.commit();

    }

    public void textSize(View view) {

        if (textView1.getVisibility() == View.VISIBLE) {
            textView1.setVisibility(View.GONE);
            textView2.setVisibility(View.GONE);
            textView3.setVisibility(View.GONE);
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, textSizeFrag);
        fragmentTransaction.commit();

    }

    public void language(View view) {

        if (textView1.getVisibility() == View.VISIBLE) {
            textView1.setVisibility(View.GONE);
            textView2.setVisibility(View.GONE);
            textView3.setVisibility(View.GONE);
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, langFrag);
        fragmentTransaction.commit();

    }

    public void home(View view) {

        finish();

    }

}
