package com.group5.respirator.Settings.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.group5.respirator.Preferences;
import com.group5.respirator.R;


public class TextSizeFragment extends Fragment implements View.OnClickListener {

    Spinner fontSizeSpinner;
    Button setSizeBtn;
    Preferences prefs;

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

        prefs = new Preferences(getContext());

        fontSizeSpinner = (Spinner) v.findViewById(R.id.font_styles);
        ArrayAdapter<Preferences.FontStyle> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, Preferences.FontStyle.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontSizeSpinner.setAdapter(adapter);

        //fontSizeSpinner.setSelection(prefs.getFontStyle().ordinal());

        setSizeBtn = (Button) v.findViewById(R.id.setSizeBtn);
        setSizeBtn.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setSizeBtn:
                Toast.makeText(getContext(), "Blablabla", Toast.LENGTH_LONG).show();
                prefs.setFontStyle((Preferences.FontStyle) fontSizeSpinner.getSelectedItem());
                break;
            default:
                break;
        }
    }
}
