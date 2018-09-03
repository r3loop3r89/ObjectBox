package com.example.shrawanwable.objectbox.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.shrawanwable.objectbox.R;
import com.example.shrawanwable.objectbox.services.BgService;

public class Utils {
    public static void showToast(Context mCtx, String text) {
        //Toast.makeText(mCtx, text, Toast.LENGTH_SHORT).show();
        ToastUtils.setBgColor(mCtx.getResources().getColor(R.color.colorAccent));
        ToastUtils.setMsgColor(mCtx.getResources().getColor(R.color.black));
        ToastUtils.setMsgTextSize(16);
        ToastUtils.showShort(text);

    }

    public static boolean isMyServiceRunning(Context mCtx, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) mCtx.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static final String TAG="ShraX";

    public static boolean cantBeEmptyET(EditText et) {
        if (et.getText().toString().trim().length()==0){
            et.setError("Can't be empty!");
            et.requestFocus();
            return true;
        }
        return false;
    }
}
