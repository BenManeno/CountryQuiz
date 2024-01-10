package org.pattersonclippers.countryquiz;

public class HighScoreObjact  implements Comparable<HighScoreObjact> {

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
    public int compareTo(HighScoreObjact otherHighScoreObject) {

        int otherScore = ((HighScoreObjact) otherHighScoreObject).getScore();


        //descending order
        return otherScore - this.score;

    }





    @Override
    public String toString() {
        return "Your name is :"+ name +"//"+"Your score was :"+ score;
    }
}
