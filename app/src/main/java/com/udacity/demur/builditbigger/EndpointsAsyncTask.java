package com.udacity.demur.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.demur.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<EndpointsAsyncTask.JokeCallback, Void, String> {
    private static MyApi myApiService = null;
    private JokeCallback callback;
    private boolean errorFlag = false;

    @Override
    protected String doInBackground(JokeCallback... params) {
        if (null == myApiService) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }
        callback = params[0];

        try {
            return myApiService.getJokeResponse().execute().getJoke();
        } catch (IOException e) {
            errorFlag = true;
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (null != callback) {
            callback.fire(result, errorFlag);
        }
    }

    public interface JokeCallback {
        void fire(String result, boolean flag);
    }
}