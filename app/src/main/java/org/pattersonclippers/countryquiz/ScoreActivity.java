package org.pattersonclippers.countryquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.net.Uri;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScoreActivity extends AppCompatActivity {

    MediaPlayer player;
    TextView scoreTV,greetingTV;
    LinearLayout backgroundColors;

    Intent incomingIntent;
    int score;
    Button emailBTN,sendScoreBTN;
//    LinearLayout backgroundColors;
    Button openHighScoreBTN;

    private String fileName= "org.pattersonclippers.countryquiz.quizApp";
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
        openHighScoreBTN=(Button)findViewById(R.id.openHighScoreBTN) ;

        myPreferences=getSharedPreferences(fileName,MODE_PRIVATE);

        name= myPreferences.getString(Name_Key,"");
        greetingUser = "Hey " + name;
        greetingTV.setText(greetingUser);




        database=FirebaseDatabase.getInstance();
        myRef = database.getReference("Score");


        int initialColor = myPreferences.getInt(Color_KEY, MODE_PRIVATE);


        if (initialColor == R.color.orange) {
            backgroundColors.setBackgroundColor(getResources().getColor(R.color.orange));
        }
        else if (initialColor == R.color.SkyBlue) {
            backgroundColors.setBackgroundColor(getResources().getColor(R.color.SkyBlue));
        }
//
//        database=FirebaseDatabase.getInstance();
//        myRef = database.getReference("Score");

        score=0;
        incomingIntent=getIntent();
        score=incomingIntent.getIntExtra("Score",0);
        scoreTV.setText("Your Score Is "+score);





        openHighScoreBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ScoreActivity.this, HighScoreActivity.class);
                startActivity(myIntent);
            }
        });








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

//                myRef.setValue(myHighScoreObject);

               String key = myRef.push().getKey();

               myRef.child(key).setValue(myHighScoreObject);


            }

        });
        player=MediaPlayer.create(ScoreActivity.this,R.raw.freefiretheme);
        player.start();
        player=MediaPlayer.create(ScoreActivity.this,R.raw.freefiretheme);
        player.stop();



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