package com.example.countryquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button ugandaBTN;
    Button polandBTN;
    TextView countryTV;
    Button doneBTN;

    int score;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ugandaBTN=(Button) findViewById(R.id.UgandaBTN);
        polandBTN =(Button) findViewById(R.id.PolandBTN);
        countryTV=(TextView) findViewById(R.id.CountryTV);
        doneBTN=(Button) findViewById(R.id.doneBTN) ;

        score=0;


        ugandaBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text="Right";
                int duration =Toast.LENGTH_SHORT;
                Toast t =Toast.makeText(getApplicationContext(),text,duration);
                t.show();
                score=score+1;

            }

        });

        polandBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text="Wrong";
                int duration=Toast.LENGTH_SHORT;
                Toast t =Toast.makeText(getApplicationContext(),text,duration);
                t.show();
            }
        });

        doneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(MainActivity.this, ScoreActivity.class);
                myIntent.putExtra("Score",score);
                startActivity(myIntent);
            }
        });

    }
}