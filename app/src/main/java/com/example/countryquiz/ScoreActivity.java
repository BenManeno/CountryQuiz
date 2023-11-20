package com.example.countryquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.net.Uri;

import com.google.android.material.color.utilities.Score;

public class ScoreActivity extends AppCompatActivity {
    TextView scoreTV;
    //LinearLayout backgroundColors;

    Intent incomingIntent;
    int score;
    Button emailBTN,saveBTN;

//    private String fileName= "com.example.countryquiz.quizApp";
//    private SharedPreferences myPreferences;
//    SharedPreferences.Editor preferencesEditor;
//   private final String Color_KEY="color";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreTV=(TextView) findViewById(R.id.scoreTV);
        //saveBTN=(Button)findViewById(R.id.saveBTN);
        emailBTN=(Button) findViewById(R.id.emailBTN);
        //backgroundColors=(LinearLayout) findViewById(R.id.backgroundColors);
        score=0;
        incomingIntent=getIntent();
        score=incomingIntent.getIntExtra("Score",0);
        scoreTV.setText("Your Score Is "+score);


//        myPreferences=getSharedPreferences(fileName,MODE_PRIVATE);
//        preferencesEditor=myPreferences.edit();
//
//
//     int bColors = myPreferences.getInt(Color_KEY,1);
//     if (bColors==R.color.Blue){
//         backgroundColors.setBackgroundColor(getResources().getColor(R.color.Blue));
//     }



        emailBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String body="Your score is "+score;
                String subject="Your score for country app ";
                composeEmail(body,subject);



            }
        });
//        saveBTN.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                backgroundColors.setBackgroundColor(getResources().getColor(R.color.Blue));
//                preferencesEditor.putInt(Color_KEY,R.color.Blue);
//                preferencesEditor.apply();
//            }
//        });


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