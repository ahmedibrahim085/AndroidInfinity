package BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class BOOT_COMPLETED extends BroadcastReceiver {

    public BOOT_COMPLETED() {
        // BroadcastReceiver BOOT_COMPLETED Empty Constructor
    }

    private static Logger LOG = LoggerFactory.getLogger(BOOT_COMPLETED.class);

    @Override
    public void onReceive(Context context, Intent intent) {

    }
}
