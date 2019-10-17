package com.udacity.demur.builditbigger;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.demur.jokepresenter.JokeActivity;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;

    private MainActivityFragment mainActivityFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        setUpLoadingAppearance(true);
        final AsyncTask<EndpointsAsyncTask.JokeCallback, Void, String> loadJoke = new EndpointsAsyncTask();
        loadJoke.execute(new EndpointsAsyncTask.JokeCallback() {
            @Override
            public void fire(final String result, boolean errorFlag) {
                if (errorFlag) {
                    setUpLoadingAppearance(false);
                    Log.e("Error loading joke:", result);
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                } else {
                    mInterstitialAd = new InterstitialAd(getApplicationContext());
                    mInterstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));
                    mInterstitialAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdLoaded() {
                            super.onAdLoaded();
                            setUpLoadingAppearance(false);
                            mInterstitialAd.show();
                        }

                        @Override
                        public void onAdClosed() {
                            launchJokeActivity(result);
                        }

                        @Override
                        public void onAdFailedToLoad(int i) {
                            super.onAdFailedToLoad(i);
                            setUpLoadingAppearance(false);
                            launchJokeActivity(result);
                        }
                    });

                    AdRequest adRequest = new AdRequest.Builder()
                            .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                            .build();
                    mInterstitialAd.loadAd(adRequest);
                }
            }
        });
    }

    private void launchJokeActivity(String joke) {
        final Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_EXTRAS_KEY, joke);
        this.startActivity(intent);
    }

    private void setUpLoadingAppearance(boolean state) {
        if (null == mainActivityFragment) {
            mainActivityFragment = (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        }
        if (null != mainActivityFragment) {
            mainActivityFragment.setLoadingAppearance(state);
        }
    }
}