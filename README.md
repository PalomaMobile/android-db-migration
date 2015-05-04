[![Build Status](https://travis-ci.org/PalomaMobile/android-db-migration.svg)](https://travis-ci.org/PalomaMobile/android-db-migration)

# android-db-migration
Android client library to help manage database migrations.

The android-db-migration project provides a library that eases the pains of upgrading database schemas in Android clients.

__Features:__

* Seamlessly upgrade multiple schema versions
* Verify DB schema upgrade integrity inside unit tests (i.e: detect if a migration script is missing for a particular schema version) 
* Easy to integrate with manual DAO code or frameworks like GreenDAO
* Minimal overhead

The project includes a sample app to get you started.

# Building the library

You can build from source via Gradle using the [Android Tools Gradle Plugin](http://tools.android.com/tech-docs/new-build-system/user-guide#TOC-Dependencies-Android-Libraries-and-Multi-project-setup). 
Building the library requires the Java 7 SDK and Android SDK.

To build of all library .aar files and sample app .apk files run:

`gradle clean build`

To build and install library .aar files to your local maven repo run:

`gradle installLibraries`

To unit tests in VM during build run:

`gradle clean assembleDebug testDebug`

To execute tests (instrumentation or unit) on device run:

`gradle clean connectedAndroidTest`


# Attributions
This implementation makes use of ideas discussed in an article by [Jeremy Connor](https://plus.google.com/u/0/+JeremyConnor/posts). The original article was [here](http://www.androidanalyse.com/greendao-schema-migration/) but the link now appears broken.
