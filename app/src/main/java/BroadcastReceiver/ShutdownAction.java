package broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.wordpress.ahmedibrahim085.androidinfinity.R;

import java.util.Calendar;

public class ShutdownAction extends BroadcastReceiver {
    public ShutdownAction() {
    }

    private String TAG = "ShutdownAction";

    @Override
    public void onReceive(Context context, Intent intent) {
        // an Intent broadcast.
        String intentAction = intent.getAction();
        String action1 = context.getResources().getString(R.string.shutdown_action1);
        String action2 = context.getResources().getString(R.string.shutdown_action2);
        Log.d(TAG, "Shutdown Action Received : " + intent.getAction());
        if(intentAction.equals(action1)
                || intentAction.equals(action2)){
            Log.d(TAG, "Shutdown Action Received : " + Calendar.getInstance().getTime());
            // Implement your Logic here & be as quick as possible.
        }
    }
}
