package com.group5.respirator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CallActivity extends AppCompatActivity implements OnClickListener {

    private Button confirmCallButton;
    private Button cancelCallButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        confirmCallButton = (Button) findViewById(R.id.confirmCallButton);
        cancelCallButton = (Button) findViewById(R.id.cancelCallButton);

    }

    @Override
    public void onClick(View view) {
        if (view == confirmCallButton){
            //some weird shit here!
        }
        else if (view == cancelCallButton){
            finish();
        }
    }
}
