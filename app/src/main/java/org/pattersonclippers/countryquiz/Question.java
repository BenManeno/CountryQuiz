package org.pattersonclippers.countryquiz;

public class Question {

    //instance variables
    private String questionText;
    private String correctAnswer;
    private String hintWeb;
    private int image ;

    String buttonOneText,buttonTwoText;

    //default constructor

    public Question(){
        questionText="";
        correctAnswer= "";
        buttonOneText="";
        buttonTwoText="";

        image=0;

        hintWeb="";
    }

    //pass-through constructor

    public Question(String newQText,String newCorrectAnswer,String newButtonOneText,String newButtonTwoText,String newHintWeb,int newImage){
        questionText=newQText;
        correctAnswer=newCorrectAnswer;
        buttonOneText = newButtonOneText;
        buttonTwoText=newButtonTwoText;
       hintWeb=newHintWeb;
       image=newImage;

    }



    //Method

    public int getImage(){
        return image;
    }

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

    public void setImage(int image){
        this.image= image;
    }

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
