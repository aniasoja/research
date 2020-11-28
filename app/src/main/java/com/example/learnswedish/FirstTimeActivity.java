package com.example.learnswedish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

public class FirstTimeActivity extends AppCompatActivity {

    EditText fieldName;
    Button btnYes, btnNo;

    public static final String WORDS_LEARNT = "com.example.learnswedish.wordslearnt"; //adress of the file with stored data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time);

        final FirebaseAnalytics mFirebaseAnalytics;
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        fieldName = findViewById( R.id.field_name );

        btnYes = findViewById(R.id.btnYes2);
        btnNo = findViewById(R.id.btnNo2);

        String fillNameRequest = "Please, fill in your name to continue.";

        SharedPreferences getWords = getSharedPreferences(WORDS_LEARNT, MODE_PRIVATE);
        int words_learnt = getWords.getInt("words_learnt", 0);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = fieldName.getText().toString();

                if (!name.isEmpty()){

                    mFirebaseAnalytics.setUserProperty("name", name);
                    mFirebaseAnalytics.setUserProperty("experience_level", "high" );

                    SharedPreferences.Editor editor = getSharedPreferences(WORDS_LEARNT, MODE_PRIVATE).edit();
                    editor.putInt("user_exp", 1);
                    editor.commit();
                    Intent yes = new Intent(FirstTimeActivity.this, NormalActivity.class);
                    yes.putExtra("first_time", 1);
                    startActivity(yes);

                } else {
                    Toast.makeText( FirstTimeActivity.this, fillNameRequest, Toast.LENGTH_SHORT ).show();
                }
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = fieldName.getText().toString();

                if (!name.isEmpty()) {

                    mFirebaseAnalytics.setUserProperty("name", name);
                    mFirebaseAnalytics.setUserProperty( "experience_level", "low" );

                    SharedPreferences.Editor editor = getSharedPreferences( WORDS_LEARNT, MODE_PRIVATE ).edit();
                    editor.putInt( "user_exp", 2 );
                    editor.commit();

                    Intent no = new Intent( FirstTimeActivity.this, NormalActivity.class );
                    no.putExtra("first_time", 1);
                    startActivity( no );
                } else {
                    Toast.makeText( FirstTimeActivity.this, fillNameRequest, Toast.LENGTH_SHORT ).show();
                }
            }
        });
    }

}
