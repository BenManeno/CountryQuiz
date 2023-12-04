package com.example.countryquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.net.Uri;

import com.google.android.material.color.utilities.Score;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScoreActivity extends AppCompatActivity {
    TextView scoreTV,greetingTV;
    //LinearLayout backgroundColors;

    Intent incomingIntent;
    int score;
    Button emailBTN,sendScoreBTN;
    LinearLayout backgroundColors;

    private String fileName= "com.example.countryquiz.quizApp";
    private SharedPreferences myPreferences;

    HighScoreObjact myHighScoreObject;

    FirebaseDatabase database;
    DatabaseReference myRef;
   private final String Color_KEY="color";
    private final String Name_Key="name";


    String greetingUser;
    String name;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        sendScoreBTN=(Button)findViewById(R.id.sendScoreBTN) ;
        greetingTV=(TextView)findViewById(R.id.greetingTV);
        scoreTV=(TextView) findViewById(R.id.scoreTV);
        emailBTN=(Button) findViewById(R.id.emailBTN);
        backgroundColors=(LinearLayout) findViewById(R.id.backgroundColors);

        myPreferences=getSharedPreferences(fileName,MODE_PRIVATE);
        database=FirebaseDatabase.getInstance();
        myRef = database.getReference("Score");

        score=0;
        incomingIntent=getIntent();
        score=incomingIntent.getIntExtra("Score",0);
        scoreTV.setText("Your Score Is "+score);


        name= myPreferences.getString(Name_Key,"");
        greetingUser = "Hey " + name;
        greetingTV.setText(greetingUser);








        emailBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String body="Your score is "+score;
                String subject="Your score for country app ";
                composeEmail(body,subject);



            }
        });
        sendScoreBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myHighScoreObject = new HighScoreObjact(name,score);

               String key = myRef.push().getKey();

               myRef.child(key).setValue(myHighScoreObject);

//                Intent myIntent =new Intent(ScoreActivity.this, HighScoreActivity.class);
//                startActivity(myIntent);
            }
        });


    }
    public void composeEmail(String body, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Only email apps handle this.
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT,body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}