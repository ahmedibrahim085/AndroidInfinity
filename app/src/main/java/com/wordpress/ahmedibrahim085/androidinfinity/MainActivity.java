package com.wordpress.ahmedibrahim085.androidinfinity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.orhanobut.bee.BeeLog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AhmedIBRAHIM.
 */
public class MainActivity extends ActionBarActivity {
    private final String TAG = "MainActivity";
    private Logger LOG = LoggerFactory.getLogger(MainActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Required call through to Activity.onCreate()
        // Restore any saved instance state
        super.onCreate(savedInstanceState);
        // Start Bee Debug and QA tool for android
//        Bee.inject(this, Bee.class);

        // Set content view
        setContentView(R.layout.android_infinity_main_activity);

        // Initialize UI elements

        // Initialize Bee Log
        BeeLog.d(TAG, "Application Started - Bee");
        Log.d(TAG, "Application Started - Log");
        LOG.debug("Application Started - SLF4j");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_android_infinity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStart() {
        super.onStart();
        LOG.info("The activity is visible and about to be started.");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        LOG.info("The activity is visible and about to be restarted.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LOG.info("The activity is and has focus (it is now \"resumed\")");
        LOG.info("Application Started - SLF4j");
        BeeLog.d(TAG, "Application Started & UI is Shown");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LOG.info("Another activity is taking focus (this activity is about to be \"paused\")");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LOG.info("The activity is no longer visible (it is now \"stopped\")");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LOG.info("The activity is about to be destroyed.");
    }

}
