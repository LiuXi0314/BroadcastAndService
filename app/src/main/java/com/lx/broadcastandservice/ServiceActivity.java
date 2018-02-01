package com.lx.broadcastandservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.widget.CompoundButton;

import com.lx.broadcastandservice.service.SimpleService;

/**
 * Service
 */
public class ServiceActivity extends AppCompatActivity {

    private SimpleService mSimpleService;
    private ServiceConnection mConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        initViews();
    }

    private void initViews() {
        SwitchCompat switchStart = (SwitchCompat) findViewById(R.id.switchStart);
        switchStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bindService();
                } else {
                    unBindService();
                }
            }
        });

        mConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d("test", name.toString());
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d("test", name.toString());
            }
        };

        SwitchCompat switchBind = (SwitchCompat) findViewById(R.id.switchBind);
        switchBind.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    startService();
                } else {
                    stopService();
                }
            }
        });
    }

    private void startService() {
        Intent intent = new Intent(this, SimpleService.class);
        startService(intent);
    }

    private void stopService() {
        stopService(new Intent(this, SimpleService.class));
    }

    private void bindService() {
        bindService(new Intent(this, SimpleService.class), mConnection, BIND_AUTO_CREATE);
    }

    private void unBindService() {
        unbindService(mConnection);
    }

}
