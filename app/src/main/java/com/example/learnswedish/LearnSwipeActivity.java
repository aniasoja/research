package com.example.learnswedish;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import java.util.ArrayList;

public class LearnSwipeActivity extends AppCompatActivity {
    ArrayList<Word> words;
    Button btnKnow;
    int words_learnt;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    public static final String WORDS_LEARNT = "com.example.learnswedish.wordslearnt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        words_learnt = getIntent().getIntExtra("words_learnt", 0);
        Log.d("words_learnt", String.valueOf(words_learnt));

        words = new ArrayList<Word>();
        words.add(new Word("I work", "jag arbetar",R.drawable.i_work, R.raw.jag_arbetar));
        words.add(new Word("a student", "en student", R.drawable.student, R.raw.en_student));
        words.add(new Word("an office worker", "en kontorist", R.drawable.office_worker, R.raw.en_kontorist));
        words.add(new Word("a waiter", "en servitör", R.drawable.waiter, R.raw.en_servitor));
        words.add(new Word("policeman", "en polis", R.drawable.policeman, R.raw.en_polis));
        words.add(new Word("firefighter", "en brandman", R.drawable.fireman, R.raw.en_brandman));
        words.add(new Word("I cook", "jag lagar mat", R.drawable.cooking, R.raw.jag_lagar_mat));
        words.add(new Word("I bake", "jag bakar", R.drawable.baking, R.raw.jag_bakar));
        words.add(new Word("a pan", "en panna", R.drawable.frying_pan, R.raw.en_panna));
        words.add(new Word("a plate", "en tallrik", R.drawable.plate, R.raw.en_tallrik));
        words.add(new Word("a microvawe", "en mikrovågsugn", R.drawable.microwave, R.raw.en_mikrovagsugn));
        words.add(new Word("a corkscrew", "en korkskruv", R.drawable.corkscrew, R.raw.en_korkskruv));
        words.add(new Word("I cycle", "jag cyklar", R.drawable.bicycle, R.raw.jag_cyklar));
        words.add(new Word("I climb", "jag klättrar", R.drawable.climbing, R.raw.jag_klattrar));
        words.add(new Word("football", "fotboll", R.drawable.football, R.raw.fotboll));
        words.add(new Word("volleyball", "volleyboll", R.drawable.volleyball, R.raw.volleyboll));
        words.add(new Word("I swim", "jag simmar", R.drawable.swimmer, R.raw.jag_simmar));
        words.add(new Word("I'm going to the gym", "Jag går till gymmet", R.drawable.gym, R.raw.jag_gar_till_gymmet));
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
        words.add(new Word("a relative", "en släkting", R.drawable.family, R.raw.en_slakting));
        words.add(new Word("I read a newspaper", "Jag läser tidningen", R.drawable.newspaper, R.raw.jag_laser_tidningen));
        words.add(new Word("I watch a movie", "Jag tittar på filmen", R.drawable.video, R.raw.jag_tittar_pa_filmen));
        words.add(new Word("I throw a party", "Jag har en fest", R.drawable.dance, R.raw.jag_har_en_fest));
        words.add(new Word("I visit an old city", "Jag besöker gamla stan", R.drawable.building, R.raw.jag_besoker_gamla_stan));
        words.add(new Word("I relax", "Jag slappar", R.drawable.relax, R.raw.jag_slappar));
        words.add(new Word("I sunbathe", "Jag solar", R.drawable.sunbathing, R.raw.jag_solar));


        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter {


        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            view1 View1 = new view1();
            view2 View2 = new view2();
            view3 View3 = new view3();

            switch (position) {
                case 0 :
                    return View1.newInstance(position + 1, words, words_learnt);
                case 1 :
                    return View2.newInstance(position + 1, words, words_learnt);
                case 2 :
                    return View3.newInstance(position + 1, words, words_learnt);
            }

            return View1.newInstance(position + 1, words, words_learnt);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }
}