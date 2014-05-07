Sneaky-Rate
============

[![Build Status](https://travis-ci.org/hotchemi/Android-Rate.png?branch=master)](https://travis-ci.org/hotchemi/Android-Rate)

Sneaky-Rate is a fork from Android-Rate that is a library to help you promote your android app by prompting users to rate the app after using it for a few days.

In addition to the functionality provided by Android-Rate, Sneaky-Rate provides an additional function.

Instead of asking if a user want to go to the rate page on Google Play, the dialog asks what the user thinks of the app. 

The dialog provides two buttons two buttons to answer this. One with a positive answer eg. Works perfekt One with a negative answer eg. It needs improvement

The positive button takes the user to the Google Play for rating. The negative lets the user send an email with feedback.

This way much of the negative feedback and ratings are sent to your mail instead of affecting your ratings on Google Play.
Sneaky Sneaky

![screen shot](http://f.st-hatena.com/images/fotolife/h/hotchemi/20140408/20140408114402.png)

## Download

Download from [maven central](http://search.maven.org/#browse%7C-2029320689).

```groovy
  dependencies {
    compile 'com.github.hotchemi:android-rate:{latest.version}'
  }
```

## ChangeLog

- 2014/02/12 0.0.2 release.

## How to use

### Implementation

Call `AppRate.monitor(Context)` and `AppRate.showRateDialogIfMeetsConditions(Context)` in your launcher activity.

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  // Monitor launch times and duration of feeding period from installation
  AppRate.monitor(this);
  // Show a dialog if meets conditions
  AppRate.showRateDialogIfMeetsConditions(this);
}
```

### Custom conditions

The default conditions to show rate dialog is as below:

* App is launched more than 10 times.
* App is launched more than 10 days later than installation.

If you want to use your own condition, please call `AppRate.setLaunchTimes(int)` and `AppRate.setInstallDays(int)`.

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    // Monitor launch times and duration of feeding period from installation
    AppRate.setInstallDays(0) // default 10, 0 means install day.
           .setLaunchTimes(3) // default 10
           .monitor(this);
    // Show a dialog if meets conditions
    AppRate.showRateDialogIfMeetsConditions(this);
}
```

### Custom rate dialog

If you want to use your own dialog labels, override string xml resources on your application.

```xml
<resources>
    <string name="rate_dialog_title">Rate this app</string>
    <string name="rate_dialog_message">If you enjoy playing this app, would you mind taking a moment to rate it? It won\'t take more than a minute. Thanks for your support!</string>
    <string name="rate_dialog_ok">Rate It Now</string>
    <string name="rate_dialog_cancel">Remind Me Later</string>
    <string name="rate_dialog_no">No, Thanks</string>
</resources>
```
And if you want to decide whether neutral button is appeared, please call `AppRate.setShowNeutralButton(boolean)`.

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    // method chain
    AppRate.setInstallDays(0)
           .setShowNeutralButton(false) // default true
           .monitor(this);
}
```

## Localization

Android-Rate currently supports the following languages:

- English
- Spanish
- French
- Chinese
- Korean
- Japanese
- Vietnamese
- Polish

## Requirements

Supports Android 2.2 or greater.

## Test

```sh
$ ./gradlew connectedCheck
```

## Contribute

1. Fork it
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Added some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create new Pull Request
