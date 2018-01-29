package com.lx.broadcastandservice;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lx.broadcastandservice.receiver.DynamicBroadCastReceiver;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DynamicBroadCastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initReceiver();
        findViewById(R.id.sendDynamicBroad).setOnClickListener(this);
        findViewById(R.id.sendStaticBroad).setOnClickListener(this);
        findViewById(R.id.sendOrderlyBroad).setOnClickListener(this);
    }

    private void initReceiver() {
        mReceiver = new DynamicBroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Keys.DynamicReceiver);
        registerReceiver(mReceiver, intentFilter);
    }

    private void sendDynamicBroadCast() {
        Intent intent = new Intent();
        intent.setAction(Keys.DynamicReceiver);
        intent.putExtra("msg", "广播广播你要去哪里");
        sendBroadcast(intent);
    }


    private void sendStaticBroadCast() {
        Intent intent = new Intent(Keys.StaticReceiver);
        intent.putExtra("msg", "你就站在那不要动，我去买几个橘子");
        sendBroadcast(intent);

    }


    private void sendOrderlyBroadCast() {
        Intent intent = new Intent();
        intent.setAction(Keys.OrderlyReceiver);
        intent.putExtra("msg", "按照大小个排序报数： ");
        sendBroadcast(intent);
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        if (id == R.id.sendDynamicBroad) {
            sendDynamicBroadCast();
        } else if (id == R.id.sendStaticBroad) {
            sendStaticBroadCast();
        } else if (id == R.id.sendOrderlyBroad) {
            sendOrderlyBroadCast();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mReceiver != null) {
            //取消注册
            unregisterReceiver(mReceiver);
        }
    }
}
