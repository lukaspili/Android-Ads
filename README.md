Android ads
===========

Air push
---------

### res/xml/preference :

	<?xml version="1.0" encoding="utf-8"?>
	<PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android">

		<android.preference.CheckBoxPreference
				android:key="@string/preferences_ads_airpush_enabled"
				android:title="@string/preferences_ads_airpush_enabled_title"
				android:summary="@string/preferences_ads_airpush_enabled_summary"/>

	</PreferenceScreen>


### Preferences.java

	SharedPreferences preferences = getPreferenceManager().getSharedPreferences();
	if (!preferences.contains(getString(R.string.preferences_ads_airpush_enabled))) {
		preferences.edit().putBoolean(getString(R.string.preferences_ads_airpush_enabled), true).commit();
	}


### AndroidManifest.xml :

    <uses-permission android:name="android.permission.INTERNET" />
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
	<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
	<uses-permission android:name="android.permission.READ_PHONE_STATE" />
	<uses-permission android:name="android.permission.VIBRATE" />
	<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>

	<application>
		<!-- Airpush -->
		<activity android:name="com.airpush.android.PushAds" android:configChanges="orientation|keyboardHidden"/>
		<receiver android:name="com.airpush.android.UserDetailsReceiver"/>
		<receiver android:name="com.airpush.android.MessageReceiver" />
		<receiver android:name="com.airpush.android.DeliveryReceiver" />
		<receiver android:name="com.siu.android.ads.airpush.AirPushBootReceiver">
			<intent-filter>
				<action android:name="android.intent.action.BOOT_COMPLETED" />
				<category android:name="android.intent.category.HOME" />
			</intent-filter>
		</receiver>

		<service android:name="com.airpush.android.PushService">
			<intent-filter>
				<action android:name="com.airpush.android.PushServiceStart<APPID>"/>
			</intent-filter>
		</service>
	</application>


### conf_airpush :

    <string name="ads_airpush_app">API_ID</string>
	<string name="ads_airpush_api">API_KEY</string>
	<bool name="ads_airpush_debug">true</bool>
	<bool name="ads_airpush_icons">true</bool>


Admob
------

### AndroidManifest.xml :

	<uses-permission android:name="android.permission.INTERNET"/>
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>

	<application>
        <!-- Admob -->
        <activity android:name="com.google.ads.AdActivity"
                  android:configChanges="keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize"/>

        <!-- Adfonic -->
        <activity android:name="com.adfonic.android.AdfonicActivity"/>

        <!-- Inmobi -->
        <activity android:name="com.inmobi.androidsdk.IMBrowserActivity" android:configChanges="keyboardHidden|orientation|keyboard"/>

        <!-- MMedia -->
        <activity android:name="com.millennialmedia.android.MMAdViewOverlayActivity" android:theme="@android:style/Theme.Translucent.NoTitleBar" android:configChanges="keyboardHidden|orientation|keyboard"/>
        <activity android:name="com.millennialmedia.android.VideoPlayer" android:configChanges="keyboardHidden|orientation|keyboard"/>
    </application>


### res/values/conf_admob.xml :

    <string name="conf_admob_banner_unitid">14d8e3d27fa74cc2</string>
    <string name="conf_admob_banner_testdevices">TEST_EMULATOR</string>


### layouts :

	xmlns:ads="http://schemas.android.com/apk/lib/com.google.ads"

	<com.google.ads.AdView android:id="@+id/adView"
                               android:layout_width="wrap_content" android:layout_height="wrap_content"
                               android:layout_alignParentBottom="true"
                               android:layout_centerHorizontal="true"
                               ads:adUnitId="@string/conf_admob_banner_unitid"
                               ads:adSize="BANNER"
                               ads:testDevices="@string/conf_admob_banner_testdevices"
                               ads:loadAdOnCreate="true"/>