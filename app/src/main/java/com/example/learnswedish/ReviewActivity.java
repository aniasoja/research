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
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Calendar;

public class ReviewActivity extends AppCompatActivity {

    ArrayList<Word> words;
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    public static final String WORDS_LEARNT = "com.example.learnswedish.wordslearnt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);


        int words_learnt = getIntent().getIntExtra("words_learnt", 0);
        Log.d("words_learnt", String.valueOf(words_learnt));


        recyclerView = findViewById(R.id.list_review);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        words = new ArrayList<Word>();
        words.add(new Word("I work", "jag arbetar", R.drawable.i_work, R.raw.jag_arbetar));
        words.add(new Word("a student", "en student", R.drawable.student, R.raw.en_student));
        words.add(new Word("an office worker", "en kontorist", R.drawable.office_worker, R.raw.en_kontorist));
        words.add(new Word("a waiter", "en servitör", R.drawable.waiter, R.raw.en_servitor));
        words.add(new Word("policeman", "en polis", R.drawable.policeman, R.raw.en_polis));
        words.add(new Word("firefighter", "en brandman", R.drawable.fireman, R.raw.en_brandman));
        words.add(new Word("I cook", "jag lagar mat", R.drawable.cooking, R.raw.jag_lagar_mat));
        words.add(new Word("I bake", "jag bakar", R.drawable.baking, R.raw.jag_bakar));
        //words.add(new Word("a pot", "", R.drawable.pan, sound));
        //words.add(new Word("a pan", "", R.drawable.frying_pan, sound));
        words.add(new Word("a microvawe", "en mikrovågsugn", R.drawable.microwave, R.raw.en_mikrovagsugn));
        words.add(new Word("a corkscrew", "en korkskruv", R.drawable.corkscrew, R.raw.en_korkskruv));
        words.add(new Word("I cycle", "jag cyklar", R.drawable.bicycle, R.raw.jag_cyklar));
        words.add(new Word("I climb", "jag klättrar", R.drawable.climbing, R.raw.jag_klattrar));
        words.add(new Word("football", "fotboll", R.drawable.football, R.raw.fotboll));
        words.add(new Word("volleyball", "volleyboll", R.drawable.volleyball, R.raw.volleyboll));
        words.add(new Word("I swim", "jag simmar", R.drawable.swimmer, R.raw.jag_simmar));
        //words.add(new Word());
        words.add(new Word("a beach", "en strand", R.drawable.beach, R.raw.en_strand));
        words.add(new Word("a forest", "en skog", R.drawable.forest, R.raw.en_skog));
        words.add(new Word("a lake", "en sjö", R.drawable.pond, R.raw.en_sjo));
        words.add(new Word("a mountain", "ett berg", R.drawable.mountains, R.raw.ett_berg));
        words.add(new Word("a meadow", "en äng", R.drawable.grass, R.raw.en_ang));
        words.add(new Word("a picnic", "en picknick", R.drawable.picnic, R.raw.en_picknick));
        words.add(new Word("a plane", "ett flygplan", R.drawable.airplane, R.raw.ett_flygplan));
        words.add(new Word("a boat", "en båt", R.drawable.yacht, R.raw.en_bat));
        words.add(new Word("a passport", "ett pass", R.drawable.passport, R.raw.ett_pass));
        words.add(new Word("an airport", "en flygplats", R.drawable.airport, R.raw.en_flygplats));
        words.add(new Word("a train station", "en tågstation", R.drawable.railway_station, R.raw.en_tagstation));
        words.add(new Word("a bus stop", "en busshållplats", R.drawable.bus_stop, R.raw.en_busshallplats));
        words.add(new Word("the only child", "enda barnet", R.drawable.boy, R.raw.enda_barnet));
        words.add(new Word("twins", "tvillingar", R.drawable.twin, R.raw.tvillingar));
        words.add(new Word("honeymoon", "en smekmånad", R.drawable.briefcase, R.raw.en_smekmanad));
        words.add(new Word("older sister", "storasyster", R.drawable.woman, R.raw.storasyster));
        words.add(new Word("younger brother", "lillebror", R.drawable.brother, R.raw.lillebror));
        //words.add();

        words.add(new Word("I read a newspaper", "Jag läser tidningen", R.drawable.newspaper, R.raw.jag_laser_tidningen));
        words.add(new Word("I watch a movie", "Jag tittar på filmen", R.drawable.video, R.raw.jag_tittar_pa_filmen));
        words.add(new Word("I throw a party", "Jag har en fest", R.drawable.dance, R.raw.jag_har_en_fest));
        words.add(new Word("I visit an old city", "Jag besöker gamla stan", R.drawable.building, R.raw.jag_besoker_gamla_stan));


        //words.add();
        //words.add();


        myAdapter = new WordAdapter(this, words, words_learnt, false);

        recyclerView.setAdapter(myAdapter);


    }
}