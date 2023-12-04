package com.example.countryquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HighScoreActivity extends AppCompatActivity {

    Button sendBTN;

    FirebaseDatabase database;
//    DatabaseReference myRef;
    final String TAG=" BCCC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        sendBTN=(Button) findViewById(R.id.sendBTN);

//        sendBTN.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseDatabase database =FirebaseDatabase.getInstance();
//                DatabaseReference myRef = database.getReference("high score");
//                myRef.setValue();
//            }
//        });




    }
}