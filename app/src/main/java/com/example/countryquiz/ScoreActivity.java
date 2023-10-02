package com.example.countryquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    TextView scoreTV;
    Intent incomingIntent;
    int score;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scoreTV=(TextView) findViewById(R.id.scoreTV);
        score=0;
        incomingIntent=getIntent();
        score=incomingIntent.getIntExtra("Score",0);
        scoreTV.setText("Your Score Is "+score);



    }
}