package com.wordpress.ahmedibrahim085.androidinfinity;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

import broadcastReceiver.BootAction;
import broadcastReceiver.ShutdownAction;

/**
 * Created by AhmedIBRAHIM on 28/02/15.
 */
public class App extends Application {

    private static Context AppContext;
    private Logger LOG = LoggerFactory.getLogger(App.class);
    private String TAG = "ApplicationClass";
    private BroadcastReceiver shutdownReceiver;
    private BroadcastReceiver bootReceiver;


    @Override
    public void onCreate() {
        AppContext = getApplicationContext();
        super.onCreate();
        Log.d(TAG, "androidInfinity Application Class Started : " + SystemClock.uptimeMillis());
        Log.d(TAG, "androidInfinity Application Class Started : " + Calendar.getInstance().getTime());
        LOG.info("androidInfinity Application Class Started : " + SystemClock.uptimeMillis());
        LOG.info("androidInfinity Application Class Started : " + Calendar.getInstance().getTime());
        Log.d(TAG, "androidInfinity Application Class Created -LogUtil");


        registerThisAppReceivers();
    }

    public Context getThisAppContext() {
        return App.AppContext;
    }

    private void registerThisAppReceivers() {
        // Boot Receiver
        bootReceiver = new BootAction();
        registerReceiver(bootReceiver, new IntentFilter(Intent.ACTION_BOOT_COMPLETED));
        // ShutDown Receiver
        shutdownReceiver = new ShutdownAction();
        registerReceiver(shutdownReceiver, new IntentFilter(Intent.ACTION_SHUTDOWN));
    }
}
