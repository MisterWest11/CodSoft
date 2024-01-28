package com.example.qoutesapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreferencesManager {
    private final SharedPreferences sharedPreferences;

    public PreferencesManager(Context context) {
        sharedPreferences = context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

    }

    //create a method to save/write to SharedPreferences
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void saveFavoriteQuote(String quote) {
        List<String> favoriteQuotes = getFavoriteQuote();
        favoriteQuotes.add(quote);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("favorite_quotes", String.join("||", favoriteQuotes));
        editor.apply();
    }

    //create a method to retrieve the favorite quote
    public List<String> getFavoriteQuote(){
        String quoteString = sharedPreferences.getString("favorite_quotes", "");
        return new ArrayList<>(Arrays.asList(quoteString.split("\\|\\|")));
    }
    //add a method to remove the quote from SharedPreference
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void removeFavoriteQuote(String quote){
        List<String> favoriteQuotes = getFavoriteQuote();
        favoriteQuotes.remove(quote);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("favorite_quotes", String.join("||", favoriteQuotes));
        editor.apply();
    }
}


