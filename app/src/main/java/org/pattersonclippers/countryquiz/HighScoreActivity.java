package org.pattersonclippers.countryquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class HighScoreActivity extends AppCompatActivity {

    private ArrayList<HighScoreObjact> myHighScoreObjects;
    private int currentIndex;
    private Button restartBTN;
    FirebaseDatabase database;
    DatabaseReference myRef;

    LinearLayout backgroundColors;

    TextView userName1TV,userScore1TV,userName2TV,userScore2TV,
            userName3TV,userScore3TV,userName4TV,userScore4TV,
            userName5TV,userScore5TV,userName6TV,userScore6TV,userName7TV,userScore7TV,greetingTV;

    private String fileName= "org.pattersonclippers.countryquiz.quizApp";
    private SharedPreferences myPreferences;

    String userName;
    int userScore;
    public static final String TAG="DDD";

    private final String Color_KEY="color";
    private final String Name_Key="name";


    String greetingUser;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        userName1TV=(TextView) findViewById(R.id.userName1TV);
        userName2TV=(TextView) findViewById(R.id.userName2TV);
        userName3TV=(TextView) findViewById(R.id.userName3TV);
        userName4TV=(TextView) findViewById(R.id.userName4TV);
        userName5TV=(TextView) findViewById(R.id.userName5TV);
        userName6TV=(TextView)findViewById(R.id.userName6TV) ;
        userName7TV=(TextView)findViewById(R.id.userName7TV) ;

        restartBTN=(Button)findViewById(R.id.restartBTN);

        //userScore1TV=(TextView)findViewById(R.id.userScore1TV);
        userScore2TV=(TextView)findViewById(R.id.userScore2TV);
        userScore3TV=(TextView)findViewById(R.id.userScore3TV);
        userScore4TV=(TextView)findViewById(R.id.userScore4TV);
        userScore5TV=(TextView)findViewById(R.id.userScore5TV);
        userScore6TV=(TextView)findViewById(R.id.userScore6TV);
        userScore7TV=(TextView)findViewById(R.id.userScore7TV);
        userScore1TV=(TextView) findViewById(R.id.userScore1TV) ;
        greetingTV=(TextView)findViewById(R.id.greetingTV);
        backgroundColors=(LinearLayout)findViewById(R.id.backgroundColors);

        myHighScoreObjects = new ArrayList<HighScoreObjact>();

        database=FirebaseDatabase.getInstance();
        myRef = database.getReference("Score");

        myPreferences=getSharedPreferences(fileName,MODE_PRIVATE);

        userName="";
        userScore=0;
        name="";

        name= myPreferences.getString(Name_Key,"");
        greetingUser = "Hey " + name +" : Congrats ! You did it  "+"\n Thanks for playing ";
        greetingTV.setText(greetingUser);



        int initialColor = myPreferences.getInt(Color_KEY, MODE_PRIVATE);

        if (initialColor == R.color.orange) {
            backgroundColors.setBackgroundColor(getResources().getColor(R.color.orange));
        }
        else if (initialColor == R.color.SkyBlue) {
            backgroundColors.setBackgroundColor(getResources().getColor(R.color.SkyBlue));
        }




        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
//                String value = String.valueOf(dataSnapshot.getValue(HighScoreObjact.class));
//                Log.d(TAG, "Value is: " + value);
                for (DataSnapshot highSnapShot : dataSnapshot.getChildren()) {
                    //From our snapshot, get the value of our key/value pair. This value
                    //contains a customer object
                    HighScoreObjact myHighScore = highSnapShot.getValue(HighScoreObjact.class);

                    myHighScoreObjects.add(myHighScore);

                    Log.d("onDataChange()", String.valueOf(myHighScore));

                }

                Collections.sort(myHighScoreObjects);



                if(myHighScoreObjects.size()>0){
                    currentIndex=0;
                    HighScoreObjact firstHighScore=myHighScoreObjects.get(currentIndex);
                    userName1TV.setText(firstHighScore.getName());
                    userScore1TV.setText(""+firstHighScore.getScore());

                }
                if (myHighScoreObjects.size() > 1) {
                    currentIndex=1;
                    HighScoreObjact nextHighScore=myHighScoreObjects.get(currentIndex);
                    userName2TV.setText(nextHighScore.getName());
                    userScore2TV.setText(""+nextHighScore.getScore());

                }
                if (myHighScoreObjects.size() > 2) {
                    currentIndex = 2;
                    HighScoreObjact nextHighScore = myHighScoreObjects.get(currentIndex);
                    userName3TV.setText(nextHighScore.getName());
                    userScore3TV.setText("" + nextHighScore.getScore());
                }
                if (myHighScoreObjects.size() > 3) {
                    currentIndex = 3;
                    HighScoreObjact nextHighScore = myHighScoreObjects.get(currentIndex);
                    userName4TV.setText(nextHighScore.getName());
                    userScore4TV.setText("" + nextHighScore.getScore());
                }
                if (myHighScoreObjects.size() > 4) {
                    currentIndex = 4;
                    HighScoreObjact nextHighScore = myHighScoreObjects.get(currentIndex);
                    userName5TV.setText(nextHighScore.getName());
                    userScore5TV.setText("" + nextHighScore.getScore());
                }
                if (myHighScoreObjects.size() > 5) {
                    currentIndex = 5;
                    HighScoreObjact nextHighScore = myHighScoreObjects.get(currentIndex);
                    userName6TV.setText(nextHighScore.getName());
                    userScore6TV.setText("" + nextHighScore.getScore());
                }
                if (myHighScoreObjects.size() > 6) {
                    currentIndex = 6;
                    HighScoreObjact nextHighScore = myHighScoreObjects.get(currentIndex);
                    userName7TV.setText(nextHighScore.getName());
                    userScore7TV.setText("" + nextHighScore.getScore());
                }




            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        restartBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent= new Intent(HighScoreActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });












    }
}