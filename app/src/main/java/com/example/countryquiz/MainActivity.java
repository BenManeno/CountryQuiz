package com.example.countryquiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button openNewBTN;



 Button notifyBtn;
    Button choiceOneBTN;
    Button choiceTwoBTN;
    TextView countryTV;
    Button NextBTN,saveQBTN;
    int score;
    int currentIndex;
    Question q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,currentQ;
    Question[]questions;
    String message;
    //LinearLayout backgroundColors;
    //    private String fileName= "com.example.countryquiz.quizApp";
//    private SharedPreferences myPreferences;
//    SharedPreferences.Editor preferencesEditor;
//   private final String Color_KEY="color";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choiceOneBTN=(Button) findViewById(R.id.UgandaBTN);
        choiceTwoBTN=(Button) findViewById(R.id.PolandBTN);
        countryTV=(TextView) findViewById(R.id.CountryTV);
        NextBTN=(Button) findViewById(R.id.NextBTN) ;
        score=0;
        //saveQBTN=(Button)findViewById(R.id.saveQBTN);

        //backgroundColors=(LinearLayout) findViewById(R.id.backgroundColors);

//        myPreferences=getSharedPreferences(fileName,MODE_PRIVATE);
//        preferencesEditor=myPreferences.edit();
//
//
//     int bColors = myPreferences.getInt(Color_KEY,1);
//     if (bColors==R.color.Blue){
//         backgroundColors.setBackgroundColor(getResources().getColor(R.color.Blue));
//     }





        q1=new Question(getString(R.string.q1text),getString(R.string.correctBTN1),getString(R.string.NewBTN1),getString(R.string.NewBText1),"https://sites.google.com/view/ben-maneno/home/about");
        q2=new Question(getString(R.string.q2text),getString(R.string.correctBTN2),getString(R.string.NewBTN2),getString(R.string.NewBText2),"https://www.britannica.com/biography/Cristiano-Ronaldo");
        q3=new Question(getString(R.string.q3text),getString(R.string.correctBTN3) ,getString(R.string.NewBTN3),getString(R.string.NewBText3),"https://www.britannica.com/biography/Lionel-Messi");
        q4=new Question(getString(R.string.q4text),getString(R.string.correctBTN4),getString(R.string.NewBTN4),getString(R.string.NewBText4),"https://currentaffairs.adda247.com/richest-country-in-the-world/#:~:text=As%20of%203rd%20September%202023,the%20GDP%20of%20%2426%2C854%20B.");
        q5=new Question(getString(R.string.q5text), getString(R.string.correctAnswer5),getString(R.string.NewBTN5),getString(R.string.NewBText5),"https://www.worldometers.info/geography/largest-countries-in-the-world/#:~:text=The%20largest%20country%20in%20the,Km%C2%B2%20(57%2C510%2C000%20square%20miles).");
        q6=new Question(getString(R.string.q6text),getString(R.string.correctAnswer6),getString(R.string.NewBTN6),getString(R.string.NewBText6),"https://www.careerpower.in/longest-river-in-the-world.html");
        q7=new Question(getString(R.string.q7text),getString(R.string.correctAnswer7),getString(R.string.NewBTN7),getString(R.string.NewBText7),"https://www.visualcapitalist.com/ranked-the-worlds-top-cobalt-producing-countries/#:~:text=The%20Democratic%20Republic%20of%20Congo,of%20global%20output%20in%202022.");
        q8=new Question(getString(R.string.q8text),getString(R.string.correctAnswer8),getString(R.string.NewBTN8),getString(R.string.NewBText8),"https://en.wikipedia.org/wiki/FIFA_Men%27s_World_Ranking");
        q9=new Question(getString(R.string.q9text),getString(R.string.correctAnswer9),getString(R.string.NewBTN9),getString(R.string.NewBText9),"https://www.usnews.com/news/best-countries/rankings/great-food");
        q10=new Question(getString(R.string.q10text),getString(R.string.correctAnswer10),getString(R.string.NewBTN10),getString(R.string.NewBText10),"https://www.usnews.com/news/best-countries/rankings/technological-expertise");

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
        openNewBTN=(Button) findViewById(R.id.openNewBTN);
        openNewBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, HintActivity.class);
                intent.putExtra("Hint",currentQ.getHintWeb());
                startActivity(intent);
            }
        });
        //        saveQ/BTN.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                backgroundColors.setBackgroundColor(getResources().getColor(R.color.Blue));
//                preferencesEditor.putInt(Color_KEY,R.color.Blue);
//                preferencesEditor.apply();
//            }
//        });





    }

}