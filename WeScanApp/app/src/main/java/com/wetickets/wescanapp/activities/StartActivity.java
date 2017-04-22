package com.wetickets.wescanapp.activities;

import android.app.Activity;
import android.os.Bundle;

import com.wetickets.wescanapp.R;

import enums.NotificationType;
import models.SettingsModel;
import utilities.LocalFileHelper;
import utilities.ToastHelper;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Hide the action bar
        getActionBar().hide();

        ToastHelper.showToast(this, "test", NotificationType.SUCCESS);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Try to load stored settings
        SettingsModel settingsModel = null;
        if(LocalFileHelper.hasSettings(this))
        {
            settingsModel = LocalFileHelper.getSettings(this);
            if(settingsModel == null)
            {
                ToastHelper.showToast(this, "Failed to load settings. Default loaded.", NotificationType.WARNING);
                LocalFileHelper.clearSettings(this);
                settingsModel = new SettingsModel();
            }
        }
        LocalFileHelper.saveSettings(this, settingsModel);
    }
}
