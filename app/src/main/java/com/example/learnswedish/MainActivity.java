package com.example.learnswedish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnLearn;
    public static final String WORDS_LEARNT = "com.example.learnswedish.wordslearnt"; //adress of the file with stored data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         //button Lean setup
         btnLearn = findViewById(R.id.btnStart);
         btnLearn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 //get the dat of the last lesson done and compare with today's data
                 int today = Calendar.DAY_OF_MONTH;
                 Log.d("today", String.valueOf(today));

                 SharedPreferences getDay = getSharedPreferences(WORDS_LEARNT, MODE_PRIVATE);
                 int lastDay = getDay.getInt("lastStudied", 0);
                 Log.d("lastDay",  String.valueOf(lastDay));

                 if (today == lastDay && lastDay != 0){ //if studied today
                     Toast.makeText(MainActivity.this, "You've learnt our top 3 words today", Toast.LENGTH_SHORT).show();
                     Log.d("yes", "yes");

                 } else {

                     //get amount of words already learnt
                     int words_learnt;
                     SharedPreferences getWords = getSharedPreferences(WORDS_LEARNT, MODE_PRIVATE);
                     words_learnt = getWords.getInt("words_learnt", 0);

                     //get amount of the words learnt stored in the app
                    int wlIntent = getIntent().getIntExtra("words_learnt", 0);

                     Log.d("words_learnt", String.valueOf(words_learnt));

                     if (words_learnt != wlIntent && wlIntent != 0){
                         Toast.makeText(MainActivity.this, "You've learnt our top 3 words today", Toast.LENGTH_SHORT).show();
                     } else {
                         Log.d("words_learnt", "going in");
                         Intent learn = new Intent(MainActivity.this, com.example.learnswedish.LearnActivity.class);
                         learn.putExtra("words_learnt", words_learnt);
                         startActivity(learn);
                     }
                }
            }
        });
    }
}
