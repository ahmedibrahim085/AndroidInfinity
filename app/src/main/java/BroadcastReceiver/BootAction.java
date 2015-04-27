package broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import com.wordpress.ahmedibrahim085.androidinfinity.App;
import com.wordpress.ahmedibrahim085.androidinfinity.R;

import java.util.Calendar;

public class BootAction extends BroadcastReceiver {

    public BootAction() {
        // broadcastReceiver BootAction Empty Constructor
    }

    private String TAG = "BootAction";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        String action1 = context.getString(R.string.boot_action1);
        String action2 = context.getString(R.string.boot_action2);
        String action3 = context.getString(R.string.boot_action3);
        Log.d(TAG, "BOOT Action Received : " + intentAction);
        if (intentAction.equals(action1)
                || intentAction.equals(action2)
                || intentAction.equals(action3)){
            Log.d(TAG, "BOOT Action Received : " + SystemClock.elapsedRealtime());
            Log.d(TAG, "BOOT Action Received : " + Calendar.getInstance().getTime());
            // Start you Application here
            App.pushAppToForeground(); // Comment this line if you want to try the approach
        }
    }
}
