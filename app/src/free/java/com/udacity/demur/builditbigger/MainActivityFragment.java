package com.udacity.demur.builditbigger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

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
        AdView mAdView = root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
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