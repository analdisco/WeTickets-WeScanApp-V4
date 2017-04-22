package utilities;

import android.app.Activity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import base.BaseActivity;
import models.SettingsModel;

/**
 * Created by dmeij on 4/22/2017.
 */

public class LocalFileHelper {

    // ---------------------------------------------------------------------------------------------
    // File names
    // ---------------------------------------------------------------------------------------------
    private static final String FILENAME_SETTINGS = "ApplicationSettings.json";


    // ---------------------------------------------------------------------------------------------
    // Settings
    // ---------------------------------------------------------------------------------------------
    public static boolean clearSettings(BaseActivity context)
    {
        if(hasSettings(context)) {
            File path = context.getFilesDir();
            File file = new File(path, FILENAME_SETTINGS);
            //Log.d("Log", "Settings: Clearing file: " + FILENAME_SETTINGS);
            return file.delete();
        }
        else {
            //Log.d("Log", "Settings: Clearing file: " + FILENAME_SETTINGS);
            return true;
        }
    }

    public static SettingsModel getSettings(BaseActivity context)
    {
        String jsonString = null;
        try {
            File file = new File(context.getFilesDir(), FILENAME_SETTINGS);
            FileInputStream fin = new FileInputStream(file);
            jsonString = convertStreamToString(fin);
            fin.close();
            Log.d("Log", "Settings: Loading json from file: " + jsonString);
            return context.globalVariables.gson.fromJson(jsonString, SettingsModel.class);

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Log", "ERROR Settings: Loading json from file: " + jsonString);
            return null;
        }
    }

    public static boolean saveSettings(BaseActivity context, SettingsModel settingsModel)
    {
        // Clear settings file
        clearSettings(context);

        File path = context.getFilesDir();
        File file = new File(path, FILENAME_SETTINGS);
        String jsonString = context.globalVariables.gson.toJson(settingsModel, SettingsModel.class);
        Log.d("Log", "Settings: Saving json to file: " + jsonString);
        try {
            FileOutputStream stream = new FileOutputStream(file);
            try {
                stream.write(jsonString.getBytes());
            } finally {
                stream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Log", "ERROR Settings: Saving json to file: " + jsonString);
            return false;
        }
        return true;
    }

    public static boolean hasSettings(BaseActivity context)
    {
        File path = context.getFilesDir();
        File file = new File(path, FILENAME_SETTINGS);
        return file.exists();
    }

    // ---------------------------------------------------------------------------------------------
    // Internal methods
    // ---------------------------------------------------------------------------------------------
    private static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }


}
