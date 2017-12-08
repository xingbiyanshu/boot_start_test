package com.kedacom.bootstarttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BootBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction().toString();
        if (action.equals(Intent.ACTION_BOOT_COMPLETED)) {
            Toast.makeText(context, "boot completed action has got", Toast.LENGTH_LONG).show();
            Log.i("BootBroadcastReceiver", "boot start!");

            Intent startIntent = context.getPackageManager()
                    .getLaunchIntentForPackage("com.kedacom.bootstarttest"); // 获取用以启动app的Intent（从第三方启动app也是通过这种手段）

            if (null == startIntent) {
                // app未安装，提示用户先安装
                Toast.makeText(context, "what!?", Toast.LENGTH_LONG).show();
            } else {
                // app已安装，则启动
                context.startActivity(startIntent);
            }
        }
    }
}
