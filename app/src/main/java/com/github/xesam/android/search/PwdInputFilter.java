package com.github.xesam.android.search;

import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;

public class PwdInputFilter implements InputFilter {
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        Log.d("filter", source + ":" + start + ":" + end + ":" + dest + ":" + dstart + ":" + dend);
        return null;
    }
}
