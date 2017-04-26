package base;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import utilities.GlobalVariables;

/**
 * Created by dmeij on 4/22/2017.
 */

public class BaseActivity extends Activity {

    // Global variables
    public GlobalVariables globalVariables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void onCreated() {
        // Log message
        //Log.d("Log", "Activity: created " + getClass().toString());
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Load global variables
        globalVariables = (GlobalVariables) getApplication();

        // Load gson builder
        globalVariables.gson = new GsonBuilder().create();
    }

    protected void onStarted() {
        // Log message
        //Log.d("Log", "Activity: started " + getClass().toString());
        Log.d("Log", "---------------------------------------------------------------------------");
    }
}
