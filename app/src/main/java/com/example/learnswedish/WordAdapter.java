package com.example.learnswedish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    private ArrayList<Word> words;

    public WordAdapter(Context context, ArrayList<Word> list){
        words = list;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivWord;
        TextView tvWord;
        ToggleButton tbWord;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            ivWord = itemView.findViewById(R.id.ivWord);
            tvWord = itemView.findViewById(R.id.tvWord);
            tbWord = itemView.findViewById(R.id.tbWord);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

    @NonNull
    @Override
    public WordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_learn1, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.ViewHolder ViewHolder, int i) {
        ViewHolder.itemView.setTag(words.get(i));
        ViewHolder.tvWord.setText(words.get(i).getSwedish_word());
        ViewHolder.tbWord.setText(words.get(i).getEnglish_word());

        if(words.get(i).getEnglish_word().equals("I work")){
            ViewHolder.ivWord.setImageResource(R.drawable.work);
        } else if(words.get(i).getEnglish_word().equals("an office worker")){
            ViewHolder.ivWord.setImageResource(R.drawable.office_worker);
        } else if(words.get(i).getEnglish_word().equals("a student")){
            ViewHolder.ivWord.setImageResource(R.drawable.student);
        }
    }

    @Override
    public int getItemCount() {
        return words.size();
    }


}