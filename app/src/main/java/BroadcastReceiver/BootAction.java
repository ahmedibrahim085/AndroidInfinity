package broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import com.wordpress.ahmedibrahim085.androidinfinity.R;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Calendar;

public class BootAction extends BroadcastReceiver {

    public BootAction() {
        // broadcastReceiver BootAction Empty Constructor
    }

    private static Logger LOG = LoggerFactory.getLogger(BootAction.class);
    private String TAG = "BootAction";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        String action1 = context.getString(R.string.boot_action1);
        String action2 = context.getString(R.string.boot_action2);
        String action3 = context.getString(R.string.boot_action3);
        if (intentAction.equals(action1)
                || intentAction.equals(action2)
                || intentAction.equals(action3)){
            Log.d(TAG, "BOOT Action Received : " + SystemClock.uptimeMillis());
            Log.d(TAG, "BOOT Action Received : " + Calendar.getInstance().getTime());
            LOG.info("BOOT Action Received : " + SystemClock.uptimeMillis());
            LOG.info("BOOT Action Received : " + Calendar.getInstance().getTime());
        }
    }
}
