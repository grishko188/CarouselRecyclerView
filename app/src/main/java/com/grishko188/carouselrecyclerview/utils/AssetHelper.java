package com.grishko188.carouselrecyclerview.utils;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Unreal Mojo
 *
 * @author Grishko Nikita
 *         on 26.10.2015.
 */
public class AssetHelper {

    public static String readFromFile(Context context, String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(fileName), "UTF-8"));

            String receiveString;
            StringBuilder sb = new StringBuilder();

            while ((receiveString = reader.readLine()) != null) {
                sb.append(receiveString);
                sb.append('\n');
            }
            return sb.toString();
        } catch (IOException e) {
            Log.d("AssetHelper", "Reading Mock data exception " + e.toString());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.d("AssetHelper", "Reading Mock data exception " + e.toString());
                }
            }
        }
        return null;
    }

    public static String getPhotoPath(String fileName) {
        return String.format("file:///android_asset/photos/%s.jpg", fileName);
    }
}
