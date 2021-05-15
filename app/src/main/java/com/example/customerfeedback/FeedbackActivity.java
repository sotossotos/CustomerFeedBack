package com.example.customerfeedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class FeedbackActivity extends AppCompatActivity {
    TextView questionLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_feedback);
        questionLabel=(TextView) findViewById(R.id.questionLabel);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String question = sp.getString("question", "Missing Question ! Set it");
        questionLabel.setText(question);
    }
}