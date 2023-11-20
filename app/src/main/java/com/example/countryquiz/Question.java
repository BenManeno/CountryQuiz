package com.example.countryquiz;

import android.widget.Button;

public class Question {

    //instance variables
    private String questionText;
    private String correctAnswer;
    private String hintWeb;

    String buttonOneText,buttonTwoText;

    //default constructor

    public Question(){
        questionText="";
        correctAnswer= "";
        buttonOneText="";
        buttonTwoText="";

        hintWeb="";
    }

    //pass-through constructor

    public Question(String newQText,String newCorrectAnswer,String newButtonOneText,String newButtonTwoText,String newHintWeb){
        questionText=newQText;
        correctAnswer=newCorrectAnswer;
        buttonOneText = newButtonOneText;
        buttonTwoText=newButtonTwoText;
       hintWeb=newHintWeb;
    }



    //Method

    public String getQuestionText(){
        return questionText;
    }

    public String getCorrectAnswer(){
        return correctAnswer;

    }
    public String getHintWeb(){
        return hintWeb;
    }
    public String getButtonOneText(){return buttonOneText;}
    public String getButtonTwoText(){return buttonTwoText;}
    //setters

    public void setQuestionText(String newQText){
        questionText=newQText;
    }
    public void setCorrectAnswer(String newAnswer){
        correctAnswer=newAnswer;
    }
    public void setButtonOneText(String newButtonOneText){
        buttonOneText=newButtonOneText;
    }
    public void setButtonTwoText(String newButtonTwoText){
        buttonTwoText=newButtonTwoText;
    }
    public void setHintWeb(String newButtonTwoText){
        hintWeb=newButtonTwoText;
    }




    @Override
    public String toString(){
        return "questionText:"+questionText+"//"+"correct Answer:"+correctAnswer;
    }
}
