package com.example.learnswedish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstTimeActivity extends AppCompatActivity {

    Button btnYes, btnNo;
    public static final String WORDS_LEARNT = "com.example.learnswedish.wordslearnt"; //adress of the file with stored data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time);

        btnYes = findViewById(R.id.btnYes2);
        btnNo = findViewById(R.id.btnNo2);

        SharedPreferences getWords = getSharedPreferences(WORDS_LEARNT, MODE_PRIVATE);
        int words_learnt = getWords.getInt("words_learnt", 0);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = getSharedPreferences(WORDS_LEARNT, MODE_PRIVATE).edit();
                editor.putInt("user_exp", 1);
                editor.commit();
                Intent yes = new Intent(FirstTimeActivity.this, NormalActivity.class);
                startActivity(yes);
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences(WORDS_LEARNT, MODE_PRIVATE).edit();
                editor.putInt("user_exp", 2);
                editor.commit();
                Intent no =  new Intent(FirstTimeActivity.this, NormalActivity.class);
                startActivity(no);
            }
        });
    }

}
