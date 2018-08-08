package com.udacity.demur.builditbigger.backend;

import com.udacity.demur.jokesjavalib.JokesProvider;

/**
 * The object model for the data we are sending through endpoints
 */
public class TheJoke {

    private String myJoke;

    public String getJoke() {
        if (null == myJoke || myJoke.isEmpty()) {
            myJoke = new JokesProvider().getJoke();
        }
        return myJoke;
    }

    public void setJoke(String data) {
        myJoke = data;
    }
}