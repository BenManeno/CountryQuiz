package com.example.countryquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.net.Uri;

public class ScoreActivity extends AppCompatActivity {
    TextView scoreTV;
    Intent incomingIntent;
    int score;
    Button emailBTN;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scoreTV=(TextView) findViewById(R.id.scoreTV);
        score=0;
        incomingIntent=getIntent();
        score=incomingIntent.getIntExtra("Score",0);
        scoreTV.setText("Your Score Is "+score);

        emailBTN=(Button) findViewById(R.id.emailBTN);
        emailBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String body="Your score is "+score;
                String subject="Your score for country app ";
                composeEmail(body,subject);
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