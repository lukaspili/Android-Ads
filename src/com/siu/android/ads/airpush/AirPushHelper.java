package com.siu.android.ads.airpush;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;
import com.airpush.android.Airpush;
import com.siu.android.ads.R;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public class AirPushHelper {

    private static final String APP = "ads_airpush_app";
    private static final String API = "ads_airpush_api";
    private static final String DEBUG = "ads_airpush_debug";
    private static final String ICONS = "ads_airpush_icons";

    public static void init(Context context) {
        if (!PreferenceManager.getDefaultSharedPreferences(context).getBoolean(context.getString(R.string.preferences_ads_airpush_enabled), true)) {
            Log.d(AirPushHelper.class.getName(), "Airpush disabled");
            return;
        }

        String appId = context.getString(getResourceId(context, APP, "string"));
        String apiKey = context.getString(getResourceId(context, API, "string"));
        boolean icons = context.getResources().getBoolean(getResourceId(context, ICONS, "bool"));

        boolean debug = false;
        try {
            debug = context.getResources().getBoolean(getResourceId(context, DEBUG, "bool"));
        } catch (RuntimeException e) {
            Log.d(AirPushHelper.class.getName(), "ads_airpush_debug resource not found, ignoring");
        }

        new Airpush(context, appId, apiKey, debug, true, icons);
    }

    public static int getResourceId(Context context, String key, String type) throws RuntimeException {
        int resource = context.getResources().getIdentifier(key, type, context.getPackageName());

        if (resource == 0) {
            throw new RuntimeException("Missing resource " + key);
        }

        return resource;
    }
}
