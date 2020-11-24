package com.example.learnswedish;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.learnswedish.R.raw.en_student;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    private ArrayList<Word> words;
    int wl;
    boolean learn;

    public static final String WORDS_LEARNT = "com.example.learnswedish.wordslearnt";

    public WordAdapter(Context context, ArrayList<Word> list, int words_learnt, boolean learn_yn){
        words = list;
        wl = words_learnt;
        learn = learn_yn;
        Log.d("today", String.valueOf(learn));
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivWord;
        TextView tvWord;
        ToggleButton tbWord;
        ImageButton btnSound;
        TextView tvTrans;


        public ViewHolder(@NonNull View itemView){
            super(itemView);
            if (learn == true){
                ivWord = itemView.findViewById(R.id.ivWord);
                tvWord = itemView.findViewById(R.id.tvWord);
                tbWord = itemView.findViewById(R.id.tbWord);
                btnSound = itemView.findViewById(R.id.btnSound);
            } else {
                ivWord = itemView.findViewById(R.id.ivWord2);
                tvWord = itemView.findViewById(R.id.tvWord2);
                tvTrans = itemView.findViewById(R.id.tvTrans);
                btnSound = itemView.findViewById(R.id.btnSound2);
            }
        }
    }

    @NonNull
    @Override
    public WordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        if (learn == true){
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, viewGroup, false);
        } else {
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items_review, viewGroup, false);
        }

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.ViewHolder ViewHolder, int i) {
        if (learn == true){
            i = i + wl;
            ViewHolder.tbWord.setText("See English");
            ViewHolder.tbWord.setTextOn(words.get(i).getEnglish_word());
        } else {
            ViewHolder.tvTrans.setText(words.get(i).getEnglish_word());
        }

        ViewHolder.itemView.setTag(words.get(i));
        ViewHolder.tvWord.setText(words.get(i).getSwedish_word());
        ViewHolder.ivWord.setImageResource(words.get(i).getWord_image());

        int sound = words.get(i).getSound();
        ViewHolder.btnSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mp = MediaPlayer.create(v.getContext(), sound);
                mp.start();;
            }
        });
    }

    @Override
    public int getItemCount() {
        if (learn == true){
            return 3;
        } else {
            Log.d("today", "wl " + wl);
            return wl;
        }
    }

}
