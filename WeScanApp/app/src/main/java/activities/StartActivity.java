package activities;

import android.os.Bundle;
import android.util.Log;

import com.wetickets.wescanapp.R;

import base.BaseActivity;
import enums.NotificationType;
import models.SettingsModel;
import utilities.LocalFileHelper;
import utilities.ToastHelper;

public class StartActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Hide the action bar
        getActionBar().hide();

        super.onCreated();
    }

    @Override
    protected void onStart() {
        super.onStart();
        
        // Try to load stored settings
        SettingsModel settingsModel;
        if(LocalFileHelper.hasSettings(this))
        {
            settingsModel = LocalFileHelper.getSettings(this);
            if(settingsModel == null) {
                Log.d("Log", "Settings: Failed to load settings. Default loaded.");
                ToastHelper.showToast(this, "Failed to load settings. Default loaded.", NotificationType.WARNING);
                LocalFileHelper.clearSettings(this);
                settingsModel = new SettingsModel();
                LocalFileHelper.saveSettings(this, settingsModel);
            }
            else {
                Log.d("Log", "Settings: Loaded json from file successfully");
            }
        }
        else {
            Log.d("Log", "Settings: Default loaded");
            settingsModel = new SettingsModel();
            LocalFileHelper.saveSettings(this, settingsModel);
        }

        // Set settings
        globalVariables.settingsModel = settingsModel;

        super.onStarted();
    }
}
