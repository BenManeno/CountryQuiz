package org.pattersonclippers.countryquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HintActivity extends AppCompatActivity {
    WebView webView;
    Intent incomingIntent;
    String hint;


    RelativeLayout backgroundColors;
    TextView greetingTV;
    Button backBTN;

    private String fileName= "org.pattersonclippers.countryquiz.quizApp";
    private SharedPreferences myPreferences;


    private final String Color_KEY="color";
    private final String Name_Key="name";
    public static final String TAG="ADD";


    String greetingUser;
    String name;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        incomingIntent=getIntent();
        hint=incomingIntent.getStringExtra("Hint");
        Log.d(TAG,"hint"+hint);

        webView=(WebView) findViewById(R.id.webView);
        greetingTV=(TextView)findViewById(R.id.greetingTV);
        backgroundColors=(RelativeLayout)findViewById(R.id.backgroundColors);
        backBTN=(Button)findViewById(R.id.backBTN);

        myPreferences=getSharedPreferences(fileName,MODE_PRIVATE);
        name= myPreferences.getString(Name_Key,"");
        Log.d(TAG,"name"+name);
        greetingUser = "Hey " + name;

        int initialColor = myPreferences.getInt(Color_KEY, MODE_PRIVATE);
        Log.d(TAG,"color"+initialColor);

        greetingTV.setText(greetingUser);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(hint);

        if (initialColor == R.color.orange) {
            backgroundColors.setBackgroundColor(getResources().getColor(R.color.orange));
        }
        else if (initialColor == R.color.SkyBlue) {
            backgroundColors.setBackgroundColor(getResources().getColor(R.color.SkyBlue));
        }

        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              onBackPressed();
            }
        });


    }





}