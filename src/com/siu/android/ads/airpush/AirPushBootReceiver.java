package com.siu.android.ads.airpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public class AirPushBootReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        AirPushHelper.init(context);
    }
}