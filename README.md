# Build It Bigger
[Udacity Grow with Google](https://www.udacity.com/grow-with-google) [Android Developer Nanodegree Program](https://www.udacity.com/course/android-developer-nanodegree-by-google--nd801)

## Overview
The task was to complete the Build It Bigger, an Android application that tells jokes.
The app should have multiple flavors that use several libraries and Google Cloud Endpoints.
The application consists of four modules: a Java library that provides jokes, a Google Cloud
Endpoints (GCE) project that serves those jokes, an Android library containing an activity for
displaying jokes, and an Android app that fetches jokes from the GCE module and passes them to
the Android library for display.

## Screenshots
<p align="center">
    <img src="screenshots/Screenshot_1.png?raw=true" width=275 />
    <img src="screenshots/Screenshot_2.png?raw=true" width=275 />
</p>

## How to work with the project
Just clone this repository or download as an archive and import in Android Studio.

## Project Requirements

### Common
- [x] App is written solely in the Java Programming Language
- [x] App utilizes stable release versions of all libraries, Gradle, and Android Studio

### Required Components
- [x] Project contains a Java library for supplying jokes
- [x] Project contains an Android library with an activity that displays jokes passed to it as intent extras
- [x] Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an `AsyncTask`
- [x] Project contains connected tests to verify that the `AsyncTask` is indeed loading jokes
- [x] Project contains paid/free flavors. The paid flavor has no ads and no unnecessary dependencies
- [x] Ads are required in the free version

### Required Behavior
- [x] App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library. Note that the GCE module need only be deployed locally
- [x] App conforms to common standards found in the [Android Nanodegree General Project Guidelines](http://udacity.github.io/android-nanodegree-guidelines/core.html)

## What have I learnt?
* Customizing the behavior of the Gradle build tool
* Adding flavors to an app, and setting up build to share code between them
* Factoring reusable functionality into a Java library
* Factoring reusable Android functionality into an Android library
* Configuring a multi-project build to compile libraries and app
* Using the Gradle App Engine plugin to deploy a backend
* Configuring an integration test suite that runs against the local App Engine development server
* Integrating AdMob into an app

## Libraries
* [AndroidX](https://developer.android.com/jetpack/androidx/) previously known as *'Android support Library'*
* [Google Cloud Endpoints](https://cloud.google.com/endpoints/docs/frameworks/java/migrating-android) helps to create, deploy, protect, monitor, analyze, and serve APIs using the same infrastructure Google uses for its own APIs
* [AdMob](https://developers.google.com/admob/android/quick-start) a mobile advertising platform that is used to generate revenue from an app
* [Espresso](https://developer.android.com/training/testing/espresso/) a testing framework that makes it easy to write reliable user interface tests

## License
    Copyright 2020 demur

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.