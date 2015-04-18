package com.wordpress.ahmedibrahim085.androidinfinity;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;

import java.util.Calendar;

import broadcastReceiver.BootAction;
import broadcastReceiver.ShutdownAction;

/**
 * Created by AhmedIBRAHIM on 28/02/15.
 */
public class App extends Application {

    private static Context AppContext;
    private static final String TAG = "ApplicationClass";
    private static BroadcastReceiver shutdownReceiver;
    private static BroadcastReceiver bootReceiver;


    @Override
    public void onCreate() {
        AppContext = getApplicationContext();
        super.onCreate();
        Log.d(TAG, "androidInfinity Application Class Started, Device booted Since : " + SystemClock.uptimeMillis() + "Milliseconds");
        Log.d(TAG, "androidInfinity Application Class Started : " + Calendar.getInstance().getTime());

        registerThisAppReceivers();

        // I assumed that you are using an old slow device like mine (I received it after 90seconds)
        // 120000 Milliseconds = 120 Seconds = 2 Minutes
        if (SystemClock.uptimeMillis()<=120000){
            Log.d(TAG, "The application is starting after a Boot action");
        }else{
            Log.d(TAG, "The application is starting after a Force-Stop action");
        }

        // Now start your application & bring it to foreground
        pushAppToForeground();
    } // End of Application Class onCreate() Method

    public static Context getThisAppContext() {
        return App.AppContext;
    }

    private void registerThisAppReceivers() {
        // Boot Broadcast is a static Receiver which means it must be added to the Manifest file
        // but not necessary here, while Shutdown broadcast is a Non-Static receiver which means
        // it must be registered inside your application

        // Boot Receiver
        bootReceiver = new BootAction();
        registerReceiver(bootReceiver, new IntentFilter(Intent.ACTION_BOOT_COMPLETED));
        // ShutDown Receiver
        shutdownReceiver = new ShutdownAction();
        registerReceiver(shutdownReceiver, new IntentFilter(Intent.ACTION_SHUTDOWN));
    }

    // Start my Application & bring it to Foreground
    public static void pushAppToForeground(){
        Intent intent = new Intent(getThisAppContext(),MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setAction(Intent.ACTION_MAIN);
        getThisAppContext().startActivity(intent);
    }
}
