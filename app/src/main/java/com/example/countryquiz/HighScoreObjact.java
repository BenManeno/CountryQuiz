package com.example.countryquiz;

import androidx.annotation.NonNull;

public class HighScoreObjact {

    private String name;
    private int score;


    public HighScoreObjact(){
        name="";
        score=0;
    }
    public HighScoreObjact(String name,int score){
        this.name=name;
        this.score=score;
    }

    public String getName(){
        return name;

    }
    public int getScore(){
        return score;
    }



    @Override
    public String toString() {
        return "Your name is :"+ name +"//"+"Your score was :"+ score;
    }
}
