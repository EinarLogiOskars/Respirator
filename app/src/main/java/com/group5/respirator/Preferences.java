package com.group5.respirator;

import android.content.Context;
import android.content.SharedPreferences;

import org.intellij.lang.annotations.JdkConstants;

/**
 * Created by Einar Logi Óskarsson on 16/01/2018.
 */

public class Preferences {
    private final static String FONT_STYLE = "FONT_STYLE";

    private final Context context;

    public Preferences(Context context) {
        this.context = context;
    }

    protected SharedPreferences open() {
        return context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
    }

    protected SharedPreferences.Editor edit() {
        return open().edit();
    }

    public FontStyle getFontStyle() {
        return FontStyle.valueOf(open().getString(FONT_STYLE,
                FontStyle.Medium.name()));
    }

    public void setFontStyle(FontStyle style) {
        edit().putString(FONT_STYLE, style.name()).commit();
    }

    public enum FontStyle {
        Small(R.style.FontStyle_Small, "Small"),
        Medium(R.style.FontStyle_Medium, "Medium"),
        Large(R.style.FontStyle_Large, "Large");

        private int resId;
        private String title;

        public int getResId() {
            return resId;
        }

        public String getTitle() {
            return title;
        }

        FontStyle(int resId, String title) {
            this.resId = resId;
            this.title = title;
        }
    }
}
