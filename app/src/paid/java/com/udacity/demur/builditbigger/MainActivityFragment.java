package com.udacity.demur.builditbigger;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ProgressBar mLoadingIndicator;
    private Button mBtnTellJoke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mLoadingIndicator = root.findViewById(R.id.pb_loading_indicator);
        mBtnTellJoke = root.findViewById(R.id.btn_tell_joke);
        return root;
    }

    public void setLoadingAppearance(boolean state) {
        if (state) {
            mBtnTellJoke.setEnabled(false);
            mLoadingIndicator.setVisibility(View.VISIBLE);
        } else {
            mBtnTellJoke.setEnabled(true);
            mLoadingIndicator.setVisibility(View.INVISIBLE);
        }
    }
}