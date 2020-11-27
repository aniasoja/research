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

    public static final String WORDS_LEARNT = "com.example.learnswedish.wordslearnt";

    public WordAdapter(Context context, ArrayList<Word> list, int words_learnt){
        words = list;
        wl = words_learnt;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivWord;
        TextView tvWord;
        ImageButton btnSound;
        TextView tvTrans;


        public ViewHolder(@NonNull View itemView){
            super(itemView);
                ivWord = itemView.findViewById(R.id.ivWord2);
                tvWord = itemView.findViewById(R.id.tvWord2);
                tvTrans = itemView.findViewById(R.id.tvTrans);
                btnSound = itemView.findViewById(R.id.btnSound2);
        }
    }

    @NonNull
    @Override
    public WordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items_review, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.ViewHolder ViewHolder, int i) {
        ViewHolder.tvWord.setText(words.get(i).getEnglish_word());

        ViewHolder.itemView.setTag(words.get(i));
        ViewHolder.tvTrans.setText(words.get(i).getSwedish_word());
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
        return wl;
    }

}
