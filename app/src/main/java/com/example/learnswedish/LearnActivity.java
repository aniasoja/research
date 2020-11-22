package com.example.learnswedish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

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

        int words_learnt = getIntent().getIntExtra("words_learnt", 0);

        btnLearnt = findViewById(R.id.btnLearnt);
        btnLearnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wl = words_learnt+3;
                SharedPreferences.Editor editor = getSharedPreferences(WORDS_LEARNT, MODE_PRIVATE).edit();
                editor.putInt("words_learnt", wl);
                editor.commit();
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

        myAdapter = new WordAdapter(this, words, words_learnt);

        recyclerView.setAdapter(myAdapter);


    }
}
