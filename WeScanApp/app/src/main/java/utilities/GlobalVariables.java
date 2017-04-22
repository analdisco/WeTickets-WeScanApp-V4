package utilities;

import android.app.Application;

import com.google.gson.Gson;

import models.SettingsModel;

/**
 * Created by dmeij on 4/22/2017.
 */

public class GlobalVariables extends Application {
    public SettingsModel settingsModel;
    public Gson gson;
}
