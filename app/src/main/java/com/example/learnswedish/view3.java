package com.example.learnswedish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link view3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class view3 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    public static final String WORDS_LEARNT = "com.example.learnswedish.wordslearnt";
    private static ArrayList<Word> words;
    private static Integer words_learnt;
    Integer sn =2;

    private Integer mParam1;

    public view3() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     *
     * @return
     */
    public static Fragment newInstance(int sectionNumber, ArrayList<Word> words2, Integer wl) {
        words = words2;
        words_learnt = wl;
        view3 fragment = new view3();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_SECTION_NUMBER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_view1, container, false);
        ImageView ivWord = rootView.findViewById(R.id.ivWord4);
        TextView tvWord = rootView.findViewById(R.id.tvWord4);
        ToggleButton tbWord = rootView.findViewById(R.id.tbWord4);
        ImageView ivSound = rootView.findViewById(R.id.btnSound4);
        //textView.setText(getString(getArguments().getInt(ARG_SECTION_NUMBER)));

        tvWord.setText(words.get(sn+words_learnt).getEnglish_word());
        ivWord.setImageResource(words.get(sn+words_learnt).getWord_image());
        tbWord.setText("See Swedish");
        tbWord.setTextOff("See Swedish");
        tbWord.setTextOn(words.get(sn+words_learnt).getSwedish_word());
        int sound = words.get(sn+words_learnt).getSound();
        ivSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mp = MediaPlayer.create(v.getContext(), sound);
                mp.start();;
            }
        });
        tbWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tbWord.isChecked()){
                    final MediaPlayer mp = MediaPlayer.create(v.getContext(), sound);
                    mp.start();;
                }
            }
        });
        Button btnKnow = rootView.findViewById(R.id.btnKnow);
        btnKnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wl = words_learnt+3;
                int today = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
                SharedPreferences.Editor editor = getActivity().getSharedPreferences(WORDS_LEARNT, getContext().MODE_PRIVATE).edit();
                editor.putInt("words_learnt", wl);
                editor.putInt("lastStudied", today);
                editor.commit();

                Intent back = new Intent(getActivity(), MainActivity.class);
                back.putExtra("words_learnt", wl);
                startActivity(back);
            }
        });
        ImageView btnSwipe = rootView.findViewById(R.id.ivSwipe);
        btnSwipe.setVisibility(rootView.GONE);

        return rootView;

    }
}