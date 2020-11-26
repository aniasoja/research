package com.example.learnswedish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class NormalActivity extends AppCompatActivity {

    Button btnLearn;
    Button btnReview;
    public static final String WORDS_LEARNT = "com.example.learnswedish.wordslearnt"; //adress of the file with stored data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        //button Lean setup
        btnLearn = findViewById(R.id.btnStart);
        btnLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get the dat of the last lesson done and compare with today's data
                int today = Calendar.DAY_OF_MONTH;

                SharedPreferences getDay = getSharedPreferences(WORDS_LEARNT, MODE_PRIVATE);
                int lastDay = getDay.getInt("lastStudied", 0);
                //int lastDay = 0; //comment two lines above and uncomment this for infinite learning

                if (today == lastDay && lastDay != 0){ //if studied today
                    Toast.makeText(NormalActivity.this, "You've learnt our top 3 words today", Toast.LENGTH_SHORT).show();

                } else {
                    //get amount of words already learnt
                    int words_learnt; //for review function to start from 0
                    SharedPreferences getWords = getSharedPreferences(WORDS_LEARNT, MODE_PRIVATE);
                    words_learnt = getWords.getInt("words_learnt", 0);

                    //get amount of the words learnt stored in the app
                    int wlIntent = getIntent().getIntExtra("words_learnt", 0);


                    if (words_learnt != wlIntent && wlIntent != 0){
                        Toast.makeText(NormalActivity.this, "You've learnt our top 3 words today", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent learn = new Intent(NormalActivity.this, LearnSwipeActivity.class);
                        learn.putExtra("words_learnt", words_learnt);
                        startActivity(learn);
                    }
                }
            }
        });

        btnReview = findViewById(R.id.btnReview);
        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int words_learnt;
                SharedPreferences getWords = getSharedPreferences(WORDS_LEARNT, MODE_PRIVATE);
                words_learnt = getWords.getInt("words_learnt", 0);

                Intent review = new Intent(NormalActivity.this, com.example.learnswedish.ReviewActivity.class);
                review.putExtra("words_learnt", words_learnt);
                startActivity(review);
            }

        });

    }
}
