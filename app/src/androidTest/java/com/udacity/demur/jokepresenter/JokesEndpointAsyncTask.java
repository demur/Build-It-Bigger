package com.udacity.demur.jokepresenter;

import android.app.Application;
import android.test.ApplicationTestCase;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.udacity.demur.builditbigger.EndpointsAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
public class JokesEndpointAsyncTask extends ApplicationTestCase<Application> implements EndpointsAsyncTask.JokeCallback {

    private CountDownLatch signal;
    private String joke;

    public JokesEndpointAsyncTask() {
        super(Application.class);
    }

    @Test
    public void jokeTest() {
        try {
            signal = new CountDownLatch(1);
            new EndpointsAsyncTask().execute(this);
            signal.await(30, TimeUnit.SECONDS);
            assertNotNull("Joke String is null", joke);
            assertFalse("Joke String is empty", joke.isEmpty());
        } catch (Exception ex) {
            fail();
        }
    }

    @Override
    public void fire(String result, boolean flag) {
        this.joke = result;
        signal.countDown();
    }
}