package com.example.learnswedish;

public class Word {
    private String english_word;

    public String getEnglish_word() {
        return english_word;
    }

    public void setEnglish_word(String english_word) {
        this.english_word = english_word;
    }

    public String getSwedish_word() {
        return swedish_word;
    }

    public void setSwedish_word(String swedish_word) {
        this.swedish_word = swedish_word;
    }

    public Word(String english_word, String swedish_word, int word_image, int sound) {
        this.english_word = english_word;
        this.swedish_word = swedish_word;
        this.word_image = word_image;
        this.sound = sound;
    }

    private String swedish_word;
    private int word_image;

    public int getWord_image() {
        return word_image;
    }

    public void setWord_image(int word_image) {
        this.word_image = word_image;
    }
    private int sound;

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }
}
