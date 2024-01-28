package com.example.qoutesapplication;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();
    TextView quoteTextView;
    Button btnNextQuote, btnShareQuote, btnFavorites, btnFavoritesList;
    private PreferencesManager preferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencesManager = new PreferencesManager(this);

        quoteTextView = findViewById(R.id.quoteTextView);
        btnNextQuote = findViewById(R.id.btnNextQuote);
        btnShareQuote = findViewById(R.id.btnShareQuote);
        btnFavorites = findViewById(R.id.btnAddFavorite);
        btnFavoritesList = findViewById(R.id.btnFavoritesList);

        //view a list of favorite quotes
        btnFavoritesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavoritesList.class);
                startActivity(intent);
            }
        });

        //add action listener for favorites button to save a quote
        btnFavorites.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String quote = quoteTextView.getText().toString();
                preferencesManager.saveFavoriteQuote(quote);
                Toast.makeText(MainActivity.this, "Quote saved!", Toast.LENGTH_SHORT).show();
            }
        });

        //create functionality for next button
        btnNextQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                displayedQuotes();
            }
        });
        displayedQuotes();


        //create the functionality for share button
        btnShareQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT,quoteTextView.getText().toString());
                //shareIntent.setPackage("com.whatsapp");
                if(shareIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(shareIntent);
                } else{
                    Toast.makeText(MainActivity.this, "App is not installed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    //create a public void method to display the quotes.
    public void displayedQuotes(){
        int randomNumber = random.nextInt((20 + 1) - 1) + 1;
        String random_quote = "";

        switch(randomNumber) {
            case 1:
                random_quote = getString(R.string.quote1);
                break;
            case 2:
                random_quote = getString(R.string.quote2);
                break;
            case 3:
                random_quote = getString(R.string.quote3);
                break;
            case 4:
                random_quote = getString(R.string.quote4);
                break;
            case 5:
                random_quote = getString(R.string.quote5);
                break;
            case 6:
                random_quote = getString(R.string.quote6);
                break;
            case 7:
                random_quote = getString(R.string.quote7);
                break;
            case 8:
                random_quote = getString(R.string.quote8);
                break;
            case 9:
                random_quote = getString(R.string.quote9);
                break;
            case 10:
                random_quote = getString(R.string.quote10);
                break;
            case 11:
                random_quote = getString(R.string.quote11);
                break;
            case 12:
                random_quote = getString(R.string.quote12);
                break;
            case 13:
                random_quote = getString(R.string.quote13);
                break;
            case 14:
                random_quote = getString(R.string.quote14);
                break;
            case 15:
                random_quote = getString(R.string.quote15);
                break;
            case 16:
                random_quote = getString(R.string.quote16);
                break;
            case 17:
                random_quote = getString(R.string.quote17);
                break;
            case 18:
                random_quote = getString(R.string.quote18);
                break;
            case 19:
                random_quote = getString(R.string.quote19);
                break;
            case 20:
                random_quote = getString(R.string.quote20);
                break;
        }

        quoteTextView.setText(random_quote);
    }
}
