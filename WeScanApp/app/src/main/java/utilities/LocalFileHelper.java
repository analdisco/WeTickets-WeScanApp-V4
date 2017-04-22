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
    public static boolean clearSettings(Activity context)
    {
        if(hasSettings(context))
        {
            File path = context.getFilesDir();
            File file = new File(path, FILENAME_SETTINGS);
            return file.delete();
        }
        else
        {
            return true;
        }
    }

    public static SettingsModel getSettings(Activity context)
    {
        try {
            File path = context.getFilesDir();
            File file = new File(path, FILENAME_SETTINGS);
            FileInputStream fin = new FileInputStream(file);
            String ret = null;
            ret = convertStreamToString(fin);
            fin.close();

            Gson gson;
            GsonBuilder gsonBuilder = new GsonBuilder();
            gson = gsonBuilder.create();

            return gson.fromJson(ret, SettingsModel.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean saveSettings(Activity context, SettingsModel settingsModel)
    {
        clearSettings(context);
        File path = context.getFilesDir();
        File file = new File(path, FILENAME_SETTINGS);

        Gson gson;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        String jsonString = gson.toJson(settingsModel, SettingsModel.class);
        Log.d("", "");
        try {
            FileOutputStream stream = new FileOutputStream(file);
            try {
                stream.write(jsonString.getBytes());
            } finally {
                stream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean hasSettings(Activity context)
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
