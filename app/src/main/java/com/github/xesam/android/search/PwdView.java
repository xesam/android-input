package com.github.xesam.android.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.github.xesam.android.input.InputFilterHelper;
import com.github.xesam.android.input.SearchController;

public class PwdView extends LinearLayout {
    private SearchController searchController;
    private EditText vEdit;
    private View vAction;

    public PwdView(Context context) {
        this(context, null);
    }

    public PwdView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PwdView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.pwd_view, this, true);
        vEdit = findViewById(R.id.edit);
        vAction = findViewById(R.id.clear);
        searchController = new SearchController();
        InputFilterHelper.addFilter(vEdit, new PwdInputFilter());
    }
}
