package com.udacity.demur.jokepresenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeFragment extends Fragment {

    public JokeFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke, container, false);
        TextView textView = rootView.findViewById(R.id.tv_joke);
        if (getActivity() instanceof JokeActivity && null != getActivity().getIntent()
                && null != getActivity().getIntent().getExtras()
                && getActivity().getIntent().hasExtra(JokeActivity.JOKE_EXTRAS_KEY)) {
            textView.setText(getActivity().getIntent().getExtras().getString(JokeActivity.JOKE_EXTRAS_KEY));
        }
        return rootView;
    }
}