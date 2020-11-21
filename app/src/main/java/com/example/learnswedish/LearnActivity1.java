package com.example.learnswedish;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LearnActivity1 extends AppCompatActivity{

    ArrayList<Word> words;
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn1);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        words = new ArrayList<Word>();
        words.add(new Word("I work", "jag arbetar"));
        words.add(new Word("a student", "en student"));
        words.add(new Word("an office worker", "en kontorist"));

        myAdapter = new WordAdapter(this, words);

        recyclerView.setAdapter(myAdapter);
    }
}

