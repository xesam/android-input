package com.github.xesam.android.input;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class SearchController {
    public interface OnInputClearListener {
        void onClear(EditText editText);
    }

    public interface OnSearchTriggerListener {
        void OnSearchTriggered(Editable s);
    }

    private EditText vEdit;
    private View vClear;
    private View vSearch;
    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (TextUtils.isEmpty(s)) {
                vClear.setVisibility(View.GONE);
                if (mOnInputClearListener != null) {
                    mOnInputClearListener.onClear(vEdit);
                }
            } else {
                vClear.setVisibility(View.VISIBLE);
            }
        }
    };

    private OnInputClearListener mOnInputClearListener;
    private OnSearchTriggerListener mOnSearchTriggerListener;

    public SearchController attach(final EditText editText) {
        this.vEdit = editText;
        this.vEdit.removeTextChangedListener(mTextWatcher);
        this.vEdit.addTextChangedListener(mTextWatcher);
        return this;
    }

    public SearchController enableClear(View clear) {
        this.vClear = clear;
        this.vClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vEdit.setText(null);
            }
        });
        return this;
    }

    public SearchController enableSearch(View search) {
        this.vSearch = search;
        this.vSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnSearchTriggerListener != null) {
                    mOnSearchTriggerListener.OnSearchTriggered(vEdit.getText());
                }
            }
        });
        return this;
    }

    public SearchController enableImeOptionsSearch() {
        vEdit.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        vEdit.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        vEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH && mOnSearchTriggerListener != null) {
                    mOnSearchTriggerListener.OnSearchTriggered(vEdit.getText());
                    return true;
                }

                return false;
            }
        });
        return this;
    }

    public SearchController setOnInputClearListener(OnInputClearListener listener) {
        this.mOnInputClearListener = listener;
        return this;
    }

    public SearchController setOnSearchTriggerListener(OnSearchTriggerListener listener) {
        this.mOnSearchTriggerListener = listener;
        return this;
    }
}
