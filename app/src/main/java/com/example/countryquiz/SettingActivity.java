package com.example.countryquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SettingActivity extends AppCompatActivity {

    EditText nameET;
    Button blue, orange, login, saveBTN;
    //    SharedPreferences preferences;
//    SharedPreferences.Editor editor;
    LinearLayout backgroundColors;
    private String fileName = "com.example.countryquiz.quizApp";
    private SharedPreferences myPreferences;
    private final String COLOR_KEY = "color";
    private final String NAME_KEY = "name";
    SharedPreferences.Editor preferencesEditor;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        nameET = (EditText) findViewById(R.id.name);
        backgroundColors = (LinearLayout) findViewById(R.id.backgroundColors);
        orange = (Button) findViewById(R.id.orange);
        blue = (Button) findViewById(R.id.blue);
        login = (Button) findViewById(R.id.login);
        saveBTN = (Button) findViewById(R.id.saveBTN);
        userName="";

        myPreferences = getSharedPreferences(fileName, MODE_PRIVATE);
        preferencesEditor = myPreferences.edit();

        int initialColor = myPreferences.getInt(COLOR_KEY, MODE_PRIVATE);


        if (initialColor == R.color.orange) {
            backgroundColors.setBackgroundColor(getResources().getColor(R.color.orange));
        }
        else if (initialColor == R.color.Blue) {
            backgroundColors.setBackgroundColor(getResources().getColor(R.color.Blue));
        }

                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent myIntent = new Intent(SettingActivity.this, MainActivity.class);
                        startActivity(myIntent);
                    }

                });
                saveBTN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userName=nameET.getText().toString();
                        preferencesEditor.putString(NAME_KEY,userName);
                        preferencesEditor.apply();

                    }
                });


                blue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        backgroundColors.setBackgroundColor(getResources().getColor(R.color.Blue));
                        preferencesEditor.putInt(COLOR_KEY,R.color.Blue);
                        preferencesEditor.apply();
                    }
                });
                orange.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        backgroundColors.setBackgroundColor(getResources().getColor(R.color.orange));
                        preferencesEditor.putInt(COLOR_KEY,R.color.orange);
                        preferencesEditor.apply();
                    }
                });


            }
        }

