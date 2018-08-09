# Gradle for Android and Java Final Project

In this project, was created an app with multiple flavors that uses
multiple libraries and Google Cloud Endpoints. The finished app consists
of four modules. A Java library that provides jokes, a Google Cloud Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

## Why this Project

As Android projects grow in complexity, it becomes necessary to customize the
behavior of the Gradle build tool, allowing automation of repetitive tasks.
Particularly, factoring functionality into libraries and creating product
flavors allow for much bigger projects with minimal added complexity.

## What Have Been Learned?

The role of Gradle in building Android Apps and how to use
Gradle to manage apps of increasing complexity. Particularly learned to:

* Add free and paid flavors to an app, and set up build to share code between them
* Factor reusable functionality into a Java library
* Factor reusable Android functionality into an Android library
* Configure a multi project build to compile libraries and app
* Use the Gradle App Engine plugin to deploy a backend
* Configure an integration test suite that runs against the local App Engine development server

## How this Project was Completed?

### Step 0: Starting Point

This is the starting point for the final project, which was provided in
the [course repository](https://github.com/udacity/ud867/tree/master/FinalProject). It
contains an activity with a banner ad and a button that purports to tell a
joke, but actually just complains. The banner ad was set up following the
instructions here:

https://developers.google.com/mobile-ads-sdk/docs/admob/android/quick-start

### Step 1: Create a Java library

First task was to create a Java library that provides jokes. A new Gradle Java project
was created using the Android Studio wizard. Then introduced a project dependency between
the app and the new Java Library.

The button was made to display a toast showing a joke retrieved from the Java joke
telling library.

### Step 2: Create an Android Library

Was created an Android Library containing an Activity that will display a joke
passed to it as an intent extra. Project dependencies were wired up so that the
button can now pass the joke from the Java Library to the Android Library.

### Step 3: Setup GCE

Instead of pulling jokes directly from the Java library, a Google Cloud Endpoints
development server was set up, and jokes are being pulled from there. The starter code
had already included the GCE module in the folder called backend.

Introduced a project dependency between the Java library
and the GCE module, and modified the GCE starter code to pull jokes from the Java library.
Created an AsyncTask to retrieve jokes using the template included in these
[instructions](https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/77e9910911d5412e5efede5fa681ec105a0f02ad/HelloEndpoints#2-connecting-your-android-app-to-the-backend). 
Maked the button kick off a task to retrieve a joke,
then launch the activity from the Android Library to display it.


### Step 4: Add Functional Tests

Added code to test that the Async task successfully retrieves a non-empty
string.

### Step 5: Add a Paid Flavor

Added free and paid product flavors to the app. Removed the ad (and all
dependencies) from the paid flavor.

## Optional Tasks

For extra practice to make the project stand out, completed the following tasks.

### Add Interstitial Ad

Followed these instructions to add an interstitial ad to the free version.
Display the ad after the user hits the button, but before the joke is shown.

https://developers.google.com/mobile-ads-sdk/docs/admob/android/interstitial

### Add Loading Indicator

Added a loading indicator that is shown while the joke is being retrieved and
disappears when the joke is ready.

### Configure Test Task

Tied it all together, created a Gradle task that:

1. Launches the GCE local development server
2. Runs all tests
3. Shuts the server down again

# Rubric

### Required Components

* Project contains a Java library for supplying jokes
* Project contains an Android library with an activity that displays jokes passed to it as intent extras.
* Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task.
* Project contains connected tests to verify that the async task is indeed loading jokes.
* Project contains paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.

### Required Behavior

* App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library.