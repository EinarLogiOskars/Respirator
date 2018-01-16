package com.group5.respirator.Settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.group5.respirator.R;

/**
 * Created by Einar Logi Óskarsson on 16/01/2018.
 */

public class baseActivity extends AppCompatActivity {
    @Override
    public void onStart() {
        super.onStart();

        // Enclose everything in a try block so we can just
        // use the default view if anything goes wrong.
        try {
            // Get the font size value from SharedPreferences.
            SharedPreferences settings =
                    getSharedPreferences("com.group5.respirator", Context.MODE_PRIVATE);

            // Get the font size option.  We use "FONT_SIZE" as the key.
            // Make sure to use this key when you set the value in SharedPreferences.
            // We specify "Medium" as the default value, if it does not exist.
            String fontSizePref = settings.getString("FONT_SIZE", "Medium");

            // Select the proper theme ID.
            // These will correspond to your theme names as defined in themes.xml.
            int themeID = R.style.FontSizeMedium;
            if (fontSizePref == "Small") {
                themeID = R.style.FontSizeSmall;
            } else if (fontSizePref == "Large") {
                themeID = R.style.FontSizeLarge;
            }

            // Set the theme for the activity.
            setTheme(themeID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
