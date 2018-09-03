package com.example.shrawanwable.objectbox.recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.shrawanwable.objectbox.utils.Utils;

public class AutoStartReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Utils.checkAutostartAndStart(context);
    }
}
