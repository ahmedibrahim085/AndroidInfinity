package broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import com.wordpress.ahmedibrahim085.androidinfinity.App;
import com.wordpress.ahmedibrahim085.androidinfinity.MainActivity;

import java.util.Calendar;

public class NetworkState extends BroadcastReceiver {
    public NetworkState() {
    } // End of the empty Constructor

    // Variables
    private final String TAG = "NetworkState";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "NetworkStateMonitor +++STARTED +++ ");
        Log.d(TAG, "NetworkStateMonitor CONNECTIVITY_CHANGE : "
                + intent.getAction());
        if ("android.net.conn.CONNECTIVITY_CHANGE"
                .equals(intent.getAction())) {
            if (!MainActivity.androidInfinityStarted){
                Log.d(TAG, "NetworkStateMonitor : " + SystemClock.elapsedRealtime());
                Log.d(TAG, "NetworkStateMonitor : " + Calendar.getInstance().getTime());
                // Start you Application here
                App.pushAppToForeground();
            }else {
                Log.d(TAG,"Application is already running");
            }
        }

        Log.d(TAG, "NetworkStateMonitor ---END/FIN--- ");
    }
}
