package com.group5.respirator.Settings;
//Author Einar Logi s165226//
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;


import com.group5.respirator.Preferences;
import com.group5.respirator.R;
import com.group5.respirator.Settings.Fragments.LanguageFragment;
import com.group5.respirator.Settings.Fragments.SoundFragment;
import com.group5.respirator.Settings.Fragments.TextSizeFragment;
import com.group5.respirator.Settings.Fragments.TouchFragment;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{

    TouchFragment touchFrag;
    SoundFragment soundFrag;
    TextSizeFragment textSizeFrag;
    LanguageFragment langFrag;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Button touchSettingBtn;
    Button soundSettingBtn;
    Button textSettingBtn;
    Button languageSettingBtn;
    Button homeBtn;

    TextView textView1;
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getTheme().applyStyle(new Preferences(this).getFontStyle().getResId(), true);
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_settings);

        fragmentManager = getSupportFragmentManager();
        touchFrag = TouchFragment.newInstance();
        soundFrag = SoundFragment.newInstance();
        textSizeFrag = TextSizeFragment.newInstance();
        langFrag = LanguageFragment.newInstance();

        int resid = R.id.fragment_container;
        Bundle b = new Bundle();
        b.putInt("resid",resid);
        textSizeFrag.setArguments(b);

        touchSettingBtn = (Button) findViewById(R.id.touchSettingsBtn);
        soundSettingBtn = (Button) findViewById(R.id.soundBtn);
        textSettingBtn = (Button) findViewById(R.id.textSizeBtn);

        languageSettingBtn = (Button) findViewById(R.id.languageBtn);
        homeBtn = (Button) findViewById(R.id.homeBtn);

        touchSettingBtn.setOnClickListener(this);
        soundSettingBtn.setOnClickListener(this);
        textSettingBtn.setOnClickListener(this);
        languageSettingBtn.setOnClickListener(this);
        homeBtn.setOnClickListener(this);

        textView2 = (TextView) findViewById(R.id.title2);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.touchSettingsBtn:
                if (textView2.getVisibility() == View.VISIBLE) {
                    textView2.setVisibility(View.GONE);
                }
                QuickTapButton(view);
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, touchFrag);
                fragmentTransaction.commit();
                break;
            case R.id.soundBtn:
                if (textView2.getVisibility() == View.VISIBLE) {
                    textView2.setVisibility(View.GONE);
                }
                QuickTapButton(view);
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, soundFrag);
                fragmentTransaction.commit();
                break;
            case R.id.textSizeBtn:
                if (textView2.getVisibility() == View.VISIBLE) {
                    textView2.setVisibility(View.GONE);
                }
                QuickTapButton(view);
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, textSizeFrag);
                fragmentTransaction.commit();
                break;
            case R.id.languageBtn:
                if (textView2.getVisibility() == View.VISIBLE) {
                    textView2.setVisibility(View.GONE);
                }
                QuickTapButton(view);
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, langFrag);
                fragmentTransaction.commit();
                break;
            case R.id.homeBtn:
                finish();
                break;
        }
    }

    public void QuickTapButton(View v) {
        AlphaAnimation alphaDown = new AlphaAnimation(1.0f, 0.3f);
        AlphaAnimation alphaUp = new AlphaAnimation(0.3f, 1.0f);
        alphaDown.setDuration(1000);
        alphaUp.setDuration(500);
        alphaDown.setFillAfter(true);
        alphaUp.setFillAfter(true);
        v.startAnimation(alphaUp);
    }
}
