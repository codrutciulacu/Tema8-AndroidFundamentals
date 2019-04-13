package com.codrut.temamodul7;

import android.content.Context;
import android.content.SharedPreferences;

public class SaveDataInSharedPrefs {

    private static final String APP_KEY = "key";

    public static final String USERNAME = "username";

    public static void setStringValueInSharedPreferences(Context ctx, String key, String value) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SaveDataInSharedPrefs.APP_KEY,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getStringValueFromSharedPreferences(Context ctx, String key) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SaveDataInSharedPrefs.APP_KEY,
                Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }
}

