package com.wordpress.ahmedibrahim085.androidinfinity;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.orhanobut.bee.Bee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AhmedIBRAHIM on 28/02/15.
 */
public class App extends Application {

    private Context AppContext;
    private Logger LOG = LoggerFactory.getLogger(App.class);
    private String TAG = "ApplicationClass";

    @Override
    public void onCreate() {
        AppContext = getApplicationContext();
        Log.d(TAG,"androidInfinity Application Class Super");
        super.onCreate();
        Log.d(TAG,"androidInfinity Application Class -1-");
        // Start Bee Debug and QA tool for android
        Bee.inject(AppContext, Bee.class);

        LOG.debug("androidInfinity Application Class Created");
        Log.d(TAG,"androidInfinity Application Class Created");
    }
}
