package com.example.learnswedish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class LearnActivity extends AppCompatActivity {

    ArrayList<Word> words;
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    Button btnLearnt;
    public static final String WORDS_LEARNT = "com.example.learnswedish.wordslearnt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        Log.d("words_learnt", "getting in");

        int words_learnt = getIntent().getIntExtra("words_learnt", 0);
        Log.d("words_learnt", String.valueOf(words_learnt));

        btnLearnt = findViewById(R.id.btnLearnt);
        btnLearnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wl = words_learnt+3;
                int today = Calendar.DAY_OF_MONTH;
                SharedPreferences.Editor editor = getSharedPreferences(WORDS_LEARNT, MODE_PRIVATE).edit();
                editor.putInt("words_learnt", wl);
                editor.putInt("lastStudied", today);
                Log.d("words_learnt", String.valueOf(wl));
                editor.commit();
                SharedPreferences getWords = getSharedPreferences(WORDS_LEARNT, MODE_PRIVATE);
                int wl2 = getWords.getInt("words_learnt", 0);
                Log.d("words_learnt", String.valueOf(wl2));

                Intent back = new Intent(LearnActivity.this, com.example.learnswedish.MainActivity.class);
                back.putExtra("words_learnt", wl);
                startActivity(back);
            }
        });


        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        words = new ArrayList<Word>();
        words.add(new Word("I work", "jag arbetar"));
        words.add(new Word("a student", "en student"));
        words.add(new Word("an office worker", "en kontorist"));
        words.add(new Word("a waiter", "en servitör"));
        words.add(new Word("policeman", "en polis"));
        words.add(new Word("firefighter", "en brandman"));
        words.add(new Word("I cook", "jag lagar mat"));
        words.add(new Word("I bake", "jag bakar"));
        words.add(new Word("a pot", "en svett"));
        words.add(new Word("a pan", "en man"));
        words.add(new Word("a microvawe", "en mikrovågsugn"));
        words.add(new Word("a corkscrew", "en korkskruv"));

        myAdapter = new WordAdapter(this, words, words_learnt);

        recyclerView.setAdapter(myAdapter);


    }
}
