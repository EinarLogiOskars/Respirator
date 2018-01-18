package com.group5.respirator.Settings.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.group5.respirator.Preferences;
import com.group5.respirator.R;


public class TextSizeFragment extends Fragment implements View.OnClickListener {

    Spinner fontSizeSpinner;
    Button setSizeBtn;
    Preferences prefs;
    int resid;
    Bundle b;

    public TextSizeFragment() {
        // Required empty public constructor
    }


    public static TextSizeFragment newInstance() {
        TextSizeFragment fragment = new TextSizeFragment();
        return fragment;
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
        View v = inflater.inflate(R.layout.fragment_text_size, container, false);

        b = getArguments();
        resid = b.getInt("resid");

        prefs = new Preferences(getContext());

        fontSizeSpinner = (Spinner) v.findViewById(R.id.font_styles);
        ArrayAdapter<Preferences.FontStyle> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, Preferences.FontStyle.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontSizeSpinner.setAdapter(adapter);

        /*
        fontSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) view).setTextColor(Color.WHITE); //Change selected text color
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        */


        setSizeBtn = (Button) v.findViewById(R.id.setSizeBtn);
        setSizeBtn.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setSizeBtn:
                prefs.setFontStyle((Preferences.FontStyle) fontSizeSpinner.getSelectedItem());
                TextSizeFragment frag = new TextSizeFragment();
                frag.setArguments(b);
                getFragmentManager().beginTransaction()
                        .replace(resid, frag)
                        .commit();
                break;
            default:
                break;
        }
    }
}
