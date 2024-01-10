package org.pattersonclippers.countryquiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;


import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    ImageView imageView;

    MediaPlayer player;
    private Button openNewBTN;

 Button notifyBtn;
    Button choiceOneBTN;
    Button choiceTwoBTN;
    TextView countryTV,userNameTV;
    Button NextBTN;
    int score;
    int currentIndex;
    Question q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,currentQ;
    Question[]questions;
    String message,userName;
    LinearLayout backgroundColors;

    private String fileName= "org.pattersonclippers.countryquiz.quizApp";
    private SharedPreferences myPreferences;
   private final String Color_KEY="color";
    private final String Name_Key="name";

    FirebaseDatabase database;
    DatabaseReference myRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choiceOneBTN=(Button) findViewById(R.id.UgandaBTN);
        choiceTwoBTN=(Button) findViewById(R.id.PolandBTN);
        countryTV=(TextView) findViewById(R.id.CountryTV);
        NextBTN=(Button) findViewById(R.id.NextBTN) ;
        userNameTV=(TextView)findViewById(R.id.userNameTV) ;
        backgroundColors=(LinearLayout) findViewById(R.id.backgroundColors);

        imageView=(ImageView) findViewById(R.id.imageView);

        myPreferences=getSharedPreferences(fileName,MODE_PRIVATE);



        database=FirebaseDatabase.getInstance();
        myRef = database.getReference("Score");

        userName="";


      userName = myPreferences.getString(Name_Key,"");
      userNameTV.setText("Hello " +userName);

      int initialColor = myPreferences.getInt(Color_KEY, MODE_PRIVATE);

        if (initialColor == R.color.orange) {
            backgroundColors.setBackgroundColor(getResources().getColor(R.color.orange));
        }
        else if (initialColor == R.color.SkyBlue) {
            backgroundColors.setBackgroundColor(getResources().getColor(R.color.SkyBlue));
        }

        q1=new Question(getString(R.string.q1text),getString(R.string.correctBTN1),getString(R.string.NewBTN1),getString(R.string.NewBText1),"https://www.britannica.com/topic/list-of-state-capitals-in-the-United-States-2119210",R.drawable.washigton);
        q2=new Question(getString(R.string.q2text),getString(R.string.correctBTN2),getString(R.string.NewBTN2),getString(R.string.NewBText2),"https://www.britannica.com/biography/Cristiano-Ronaldo",R.drawable.ronaldo);
        q3=new Question(getString(R.string.q3text),getString(R.string.correctBTN3) ,getString(R.string.NewBTN3),getString(R.string.NewBText3),"https://www.britannica.com/biography/Lionel-Messi",R.drawable.messi);
        q4=new Question(getString(R.string.q4text),getString(R.string.correctBTN4),getString(R.string.NewBTN4),getString(R.string.NewBText4),"https://www.chinausfocus.com/finance-economy/redefining-economic-relations-between-china-and-us-",R.drawable.richestcountry);
        q5=new Question(getString(R.string.q5text), getString(R.string.correctAnswer5),getString(R.string.NewBTN5),getString(R.string.NewBText5),"https://www.worldometers.info/geography/largest-countries-in-the-world/#:~:text=The%20largest%20country%20in%20the,Km%C2%B2%20(57%2C510%2C000%20square%20miles).",R.drawable.biggestcountry);
        q6=new Question(getString(R.string.q6text),getString(R.string.correctAnswer6),getString(R.string.NewBTN6),getString(R.string.NewBText6),"https://www.britannica.com/place/Nile-River",R.drawable.longestriver);
        q7=new Question(getString(R.string.q7text),getString(R.string.correctAnswer7),getString(R.string.NewBTN7),getString(R.string.NewBText7),"https://www.visualcapitalist.com/ranked-the-worlds-top-cobalt-producing-countries/#:~:text=The%20Democratic%20Republic%20of%20Congo,of%20global%20output%20in%202022.",R.drawable.congocobalt);
        q8=new Question(getString(R.string.q8text),getString(R.string.correctAnswer8),getString(R.string.NewBTN8),getString(R.string.NewBText8),"https://www.careerpower.in/fifa-world-cup-winners-list.html#:~:text=Argentina%20won%20the%20FIFA%20World,and%20the%20third%20time%20overall.",R.drawable.fifa2022);
        q9=new Question(getString(R.string.q9text),getString(R.string.correctAnswer9),getString(R.string.NewBTN9),getString(R.string.NewBText9),"https://www.coe.int/en/web/interculturalcities/paris#:~:text=Paris%20is%20the%20capital%20and,parisienne%2C%20%22Paris%20Region%22.",R.drawable.france);
        q10=new Question(getString(R.string.q10text),getString(R.string.correctAnswer10),getString(R.string.NewBTN10),getString(R.string.NewBText10),"https://www.thetoptens.com/nations/high-tech-countries/",R.drawable.bestt);
        q11=new Question(getString(R.string.q11text),getString(R.string.correctAnswer11),getString(R.string.NewBTN11),getString(R.string.NewBTex11),"https://earth.esa.int/web/earth-watching/image-of-the-week/content/-/article/nairobi-kenya/index.html#:~:text=Nairobi%20is%20the%20capital%20and,which%20flows%20through%20the%20city.",R.drawable.kenya);
        q12=new Question(getString(R.string.q12text),getString(R.string.correctAnswer12),getString(R.string.NewBTN12),getString(R.string.NewBTex12),   "https://earth.esa.int/web/earth-watching/image-of-the-week/content/-/article/madrid-spain/#:~:text=Madrid%20is%20the%20capital%20and,to%20be%20around%206.5%20million.",R.drawable.spain);
        questions=new Question[]{q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12};
        currentIndex=0;

        currentQ=questions[currentIndex];
        message="";

        choiceOneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentQ.getCorrectAnswer().equals(currentQ.getButtonOneText())){
                    message =getString(R.string.correctMessage);
                    score=score+1;

                    player = MediaPlayer.create(MainActivity.this,R.raw.correct);
                    player.start();

                } else {
                    message =getString(R.string.WrongMsg);

                    player = MediaPlayer.create(MainActivity.this,R.raw.wrong);
                    player.start();

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

                    player = MediaPlayer.create(MainActivity.this,R.raw.correct);
                    player.start();



                } else {
                    message ="Wrong";

                    player = MediaPlayer.create(MainActivity.this,R.raw.wrong);
                    player.start();

                }

                int duration=Toast.LENGTH_SHORT;
                Toast t =Toast.makeText(getApplicationContext(),message,duration);
                t.show();
            }
        });

        NextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if (currentIndex<questions.length-1){
                    currentIndex++;
                    currentQ=questions[currentIndex];
                    countryTV.setText(currentQ.getQuestionText());
                    choiceOneBTN.setText(currentQ.getButtonOneText());
                choiceTwoBTN.setText(currentQ.getButtonTwoText());


                        imageView.setImageResource(currentQ.getImage());





               /// player.stop();
//                player.release();

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






    }

}