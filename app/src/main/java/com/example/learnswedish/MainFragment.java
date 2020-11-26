package com.example.learnswedish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    private static Integer lastDay;
    private static Integer words_learnt;
    Button btnLearn;
    Button btnReview;
    public static final String WORDS_LEARNT = "com.example.learnswedish.wordslearnt"; //adress of the file with stored data

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(Integer last_day, Integer wordsLearnt) {
        MainFragment fragment = new MainFragment();
        lastDay = last_day;
        words_learnt = wordsLearnt;
        Bundle args = new Bundle();
        //args.putInt(ARG_PARAM1, lastDay);
        //args.putInt(ARG_PARAM2, wordsLearnt);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }

         */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.print("userExp mainFr");
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main, container, false);

        //button Lean setup
        btnLearn = rootView.findViewById(R.id.btnStart);
        btnLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get the dat of the last lesson done and compare with today's data
                int today = Calendar.DAY_OF_MONTH;
                //int lastDay = 0;                                                                  //uncomment this for infinite learning

                if (today == lastDay && lastDay != 0){ //if studied today
                    Toast.makeText(getActivity(), "You've learnt our top 3 words today", Toast.LENGTH_SHORT).show();

                } else {
                    //int words_learnt = 0;                                                                //uncomment and set for infinite review
                    //get amount of the words learnt stored in the app
                    int wlIntent = getActivity().getIntent().getIntExtra("words_learnt", 0);

                    if (words_learnt != wlIntent && wlIntent != 0){
                        Toast.makeText(getActivity(), "You've learnt our top 3 words today", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent learn = new Intent(getActivity(), LearnSwipeActivity.class);
                        learn.putExtra("words_learnt", words_learnt);
                        startActivity(learn);
                    }
                }
            }
        });

        btnReview = rootView.findViewById(R.id.btnReview);
        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent review = new Intent(getActivity(), com.example.learnswedish.ReviewActivity.class);
                review.putExtra("words_learnt", words_learnt);
                startActivity(review);
            }

        });
        return rootView;
    }
}
