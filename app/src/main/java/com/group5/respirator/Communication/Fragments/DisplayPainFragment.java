package com.group5.respirator.Communication.Fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
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
import android.widget.RelativeLayout;
import com.group5.respirator.R;
import java.util.ArrayList;


public class DisplayPainFragment extends Fragment
{


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

        RelativeLayout relativeLayout1 = rootView.findViewById(R.id.rect1);
        RelativeLayout relativeLayout2 = rootView.findViewById(R.id.rect2);

        relativeLayout1.addView(new Drawboard(getActivity()));
        relativeLayout2.addView(new Drawboard(getActivity()));

        return rootView;
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
        public void onDraw(Canvas c) {
            for (Point p : touchPoint)
            {
                c.drawBitmap(bitmapResized, p.x, p.y, paintType);
            }
        }
    }
}



