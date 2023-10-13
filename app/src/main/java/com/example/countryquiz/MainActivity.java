package com.example.countryquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button choiceOneBTN;
    Button choiceTwoBTN;
    TextView countryTV;
    Button NextBTN;
    int score;
    int currentIndex;
    Question q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,currentQ;
    Question[]questions;
    String message;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choiceOneBTN=(Button) findViewById(R.id.UgandaBTN);
        choiceTwoBTN=(Button) findViewById(R.id.PolandBTN);
        countryTV=(TextView) findViewById(R.id.CountryTV);
        NextBTN=(Button) findViewById(R.id.NextBTN) ;
        score=0;

        q1=new Question(getString(R.string.q1text),getString(R.string.correctBTN1),getString(R.string.NewBTN1),getString(R.string.NewBText1));
        q2=new Question(getString(R.string.q2text),getString(R.string.correctBTN2),getString(R.string.NewBTN2),getString(R.string.NewBText2));
        q3=new Question(getString(R.string.q3text),getString(R.string.correctBTN3) ,getString(R.string.NewBTN3),getString(R.string.NewBText3));
        q4=new Question(getString(R.string.q4text),getString(R.string.correctBTN4),getString(R.string.NewBTN4),getString(R.string.NewBText4));
        q5=new Question(getString(R.string.q5text), getString(R.string.correctAnswer5),getString(R.string.NewBTN5),getString(R.string.NewBText5));
        q6=new Question(getString(R.string.q6text),getString(R.string.correctAnswer6),getString(R.string.NewBTN6),getString(R.string.NewBText6));
        q7=new Question(getString(R.string.q7text),getString(R.string.correctAnswer7),getString(R.string.NewBTN7),getString(R.string.NewBText7));
        q8=new Question(getString(R.string.q8text),getString(R.string.correctAnswer8),getString(R.string.NewBTN8),getString(R.string.NewBText8));
        q9=new Question(getString(R.string.q9text),getString(R.string.correctAnswer9),getString(R.string.NewBTN9),getString(R.string.NewBText9));
        q10=new Question(getString(R.string.q10text),getString(R.string.correctAnswer10),getString(R.string.NewBTN10),getString(R.string.NewBText10));

        questions=new Question[]{q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,};
        currentIndex=0;
        currentQ=questions[currentIndex];
        message="";


        choiceOneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentQ.getCorrectAnswer().equals(currentQ.getButtonOneText())){
                    message =getString(R.string.correctMessage);
                    score=score+1;



                } else {
                    message =getString(R.string.WrongMsg);

                }


                int duration =Toast.LENGTH_SHORT;
                Toast t =Toast.makeText(getApplicationContext(),message,duration);
                t.show();


            }

        });

        choiceTwoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentQ.getCorrectAnswer().equals(currentQ.getButtonTwoText())){
                    message ="Right";
                    score=score+1;



                } else {
                    message ="Wrong";

                }

                int duration=Toast.LENGTH_SHORT;
                Toast t =Toast.makeText(getApplicationContext(),message,duration);
                t.show();
            }
        });

        NextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if (currentIndex<9){
                    currentIndex++;
                    currentQ=questions[currentIndex];
                    countryTV.setText(currentQ.getQuestionText());
                    choiceOneBTN.setText(currentQ.getButtonOneText());
                choiceTwoBTN.setText(currentQ.getButtonTwoText());



                }
                else{
                    Intent myIntent=new Intent(MainActivity.this, ScoreActivity.class);
                    myIntent.putExtra("Score",score);
                   startActivity(myIntent);
                }

            }
        });

    }

}