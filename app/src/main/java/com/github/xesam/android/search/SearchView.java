package com.github.xesam.android.search;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.github.xesam.android.input.SearchController;

public class SearchView extends LinearLayout {
    private SearchController searchController;
    private EditText vEdit;
    private View vClear;
    private View vSearch;
    private SearchController.OnInputClearListener mOnInputClearListener;

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.search_view, this, true);
        vEdit = findViewById(R.id.edit);
        vClear = findViewById(R.id.clear);
        vSearch = findViewById(R.id.search);
        searchController = new SearchController()
                .attach(vEdit)
                .enableClear(vClear)
                .enableSearch(vSearch)
                .enableImeOptionsSearch()
                .setOnInputClearListener(new SearchController.OnInputClearListener() {
                    @Override
                    public void onClear(EditText editText) {
                        Log.d("onClear", "onClear");
                    }
                })
                .setOnSearchTriggerListener(new SearchController.OnSearchTriggerListener() {
                    @Override
                    public void OnSearchTriggered(Editable s) {
                        Log.d("OnSearchTriggered", "s:" + s.toString());
                    }
                });
    }
}
