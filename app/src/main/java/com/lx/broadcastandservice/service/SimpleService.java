package com.lx.broadcastandservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created on 18-1-29 下午6:25
 */

public class SimpleService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
}
