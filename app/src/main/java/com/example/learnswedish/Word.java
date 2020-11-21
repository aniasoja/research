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

    public Word(String english_word, String swedish_word) {
        this.english_word = english_word;
        this.swedish_word = swedish_word;
    }

    private String swedish_word;
}
