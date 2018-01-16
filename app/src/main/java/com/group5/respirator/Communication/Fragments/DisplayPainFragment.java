package com.group5.respirator.Communication.Fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.group5.respirator.R;
import java.util.ArrayList;


public class DisplayPainFragment extends Fragment implements View.OnClickListener
{
    private Button questionbutton1;
    private Button questionbutton2;
    private Button EraseButton;
    private Button questionbutton4;
    private Button questionbutton5;
    private Button questionbutton6;
    private RelativeLayout relativeLayout1;
    private RelativeLayout relativeLayout2;

    private ArrayList<Button> ButtonsCollection = new ArrayList<Button>();

    public DisplayPainFragment()
    {
        // Required empty public constructor
    }

    public static DisplayPainFragment newInstance()
    {
        DisplayPainFragment fragment = new DisplayPainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_display_pain, container, false);

        relativeLayout1 = rootView.findViewById(R.id.rect1);
        relativeLayout2 = rootView.findViewById(R.id.rect2);

        questionbutton1 = rootView.findViewById(R.id.questionbutton1);
        questionbutton2 = rootView.findViewById(R.id.questionbutton2);
        EraseButton = rootView.findViewById(R.id.questionbutton3);
        questionbutton4 = rootView.findViewById(R.id.questionbutton4);
        questionbutton5 = rootView.findViewById(R.id.questionbutton5);
        questionbutton6 = rootView.findViewById(R.id.questionbutton6);

        ButtonsCollection.add(questionbutton1);
        ButtonsCollection.add(questionbutton2);
        ButtonsCollection.add(questionbutton4);
        ButtonsCollection.add(questionbutton5);
        ButtonsCollection.add(questionbutton6);

        questionbutton1.setOnClickListener(this);
        questionbutton2.setOnClickListener(this);
        EraseButton.setOnClickListener(this);
        questionbutton4.setOnClickListener(this);
        questionbutton5.setOnClickListener(this);
        questionbutton6.setOnClickListener(this);

        relativeLayout1.addView(new Drawboard(getActivity()));
        relativeLayout2.addView(new Drawboard(getActivity()));

        return rootView;
    }

    @Override
    public void onClick(View v)
    {
        ButtonCleaner(v.getId());

        if (v.isSelected() == false)
        {
            if(v != EraseButton)
            {
                v.setSelected(true);
                v.getBackground().setColorFilter(new LightingColorFilter(Color.parseColor("#81858d"),0));
            }
            else
            {
                relativeLayout1.removeAllViews();
                relativeLayout2.removeAllViews();
                relativeLayout1.addView(new Drawboard(getActivity()));
                relativeLayout2.addView(new Drawboard(getActivity()));

                QuickTapButton(v);
            }

        } else
        {
            v.setSelected(false);
            v.getBackground().clearColorFilter();
        }

    }
    public void QuickTapButton(View v)
    {
        AlphaAnimation alphaDown = new AlphaAnimation(1.0f, 0.3f);
        AlphaAnimation alphaUp = new AlphaAnimation(0.3f, 1.0f);
        alphaDown.setDuration(1000);
        alphaUp.setDuration(500);
        alphaDown.setFillAfter(true);
        alphaUp.setFillAfter(true);
        v.startAnimation(alphaUp);
    }
    public void ButtonCleaner(int b)
    {
        for (int i = 0; i < ButtonsCollection.size(); i++)
        {
            if(b != ButtonsCollection.get(i).getId())
            {
                ButtonsCollection.get(i).getBackground().clearColorFilter();
                ButtonsCollection.get(i).setSelected(false);
            }
        }
    }

    private class Drawboard extends View {

        ArrayList<Point> touchPoint = new ArrayList<Point>();
        Paint paintType = new Paint();

        Bitmap markerIcon = BitmapFactory.decodeResource(getResources(), R.drawable.marker);
        Bitmap bitmapResized = markerIcon.createScaledBitmap(markerIcon, 25,25,false);

        public Drawboard(Context a)
        {
            super(a);
            paintType.setTextSize(1);
        }

        @Override
        public boolean onTouchEvent(MotionEvent b)
        {
            System.out.println(b);
            Point points = new Point((int) b.getX(), (int) b.getY());
            touchPoint.add(points);
            invalidate();
            return true;
        }

        @Override
        public void onDraw(Canvas c)
        {
            for (Point p : touchPoint)
            {
                c.drawBitmap(bitmapResized, p.x, p.y, paintType);
            }
        }
    }
}



