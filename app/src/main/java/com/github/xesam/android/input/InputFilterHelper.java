package com.github.xesam.android.input;

import android.text.InputFilter;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputFilterHelper {
    public static void addFilter(EditText targetEditText, InputFilter filter) {
        InputFilter[] filters = targetEditText.getFilters();
        List<InputFilter> filterList = new ArrayList<>();
        Collections.addAll(filterList, filters);
        filterList.add(filter);
        InputFilter[] newFilters = new InputFilter[filterList.size()];
        filterList.toArray(newFilters);
        targetEditText.setFilters(newFilters);
    }
}
