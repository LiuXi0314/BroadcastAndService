package com.lx.broadcastandservice.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created on 18-1-29 下午3:46
 */

public class FirstReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg") + "1";
        Log.d("test", msg);
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
