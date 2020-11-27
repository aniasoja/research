package com.example.learnswedish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MainActivity extends AppCompatActivity{

    public static final String WORDS_LEARNT = "com.example.learnswedish.wordslearnt"; //adress of the file with stored data
    FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        FirebaseAnalytics.getInstance(this).getAppInstanceId();

        mFirebaseAnalytics.setUserProperty("user_pseudo_id", String.valueOf( FirebaseAnalytics.getInstance(this).getAppInstanceId() ) );
        mFirebaseAnalytics.setUserProperty("name", "Pepi" );

        SharedPreferences getExp = getSharedPreferences(WORDS_LEARNT, MODE_PRIVATE);
        int userExp = getExp.getInt("user_exp", 0);
        if (userExp == 1 || userExp ==2) {
            Intent normal  = new Intent(MainActivity.this, NormalActivity.class);
            startActivity(normal);
        } else {
            Intent firstTime  = new Intent(MainActivity.this, FirstTimeActivity.class);
            startActivity(firstTime);
        }


        final String TAG = "TagName";
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                    return;
                }

                // Get new FCM registration token
                String token = task.getResult();

                // Log and toast
                //String msg = getString(R.string.msg_token_fmt, token);
                Log.d(TAG, token);
                //Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
            }
        });

    }
}