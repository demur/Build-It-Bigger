package com.udacity.demur.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.demur.udacity.com",
                ownerName = "backend.builditbigger.demur.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that returns a joke
     */
    @ApiMethod(name = "getJokeResponse")
    public TheJoke getJokeResponse() {
        return new TheJoke();
    }
}