package com.example.learnswedish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnLearn;
    public static final String WORDS_LEARNT = "com.example.learnswedish.wordslearnt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnLearn = findViewById(R.id.btnLearn);

        SharedPreferences getWords = getSharedPreferences(WORDS_LEARNT, MODE_PRIVATE);
        int words_learnt = getWords.getInt("words_learnt", 0);

        btnLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent learn = new Intent(MainActivity.this, com.example.learnswedish.LearnActivity.class);
                learn.putExtra("words_learnt", words_learnt);
                startActivity(learn);
            }
        });
    }
}
