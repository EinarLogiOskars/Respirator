package com.group5.respirator;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity implements OnClickListener {

    private Button confirmCallButton;
    private Button cancelCallButton;
    MediaPlayer apple_ring;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        confirmCallButton = (Button) findViewById(R.id.confirmCallButton);
        cancelCallButton = (Button) findViewById(R.id.cancelCallButton);

        confirmCallButton.setOnClickListener(this);
        cancelCallButton.setOnClickListener(this);

        apple_ring = MediaPlayer.create(this, R.raw.apple_ring);

    }

    @Override
    public void onClick(View view) {
        if (view == confirmCallButton){
            // Call effect, sound, something....?
            Context context = getApplicationContext();
            CharSequence text = "Call confirmed - Calling a nurse";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            apple_ring.start();
            finish();
        }
        else if (view == cancelCallButton){
            Context context = getApplicationContext();
            CharSequence text = "Call canceled";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            finish();
        }
    }
}
