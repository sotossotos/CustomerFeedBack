package com.example.customerfeedback;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SetQuestionActivity extends AppCompatActivity {
    Button clearButton;
    Button setQuestionButton;
    TextView questionText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_set_question);
        clearButton=(Button)findViewById(R.id.clearButton);
        questionText=(TextView)findViewById(R.id.questionTextBox);
        setQuestionButton=(Button)findViewById(R.id.setQuestionButton);
        setQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSetAccepted();
            }
        });
        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clearTextBox();
            }
        });
    }
    public void clearTextBox(){
        questionText.setText("");
    }
    public void textSetAccepted(){

        if (questionText.length()>0 && (questionText.getText().toString().contains("?")  || questionText.getText().toString().contains(";"))){
            setQuestionButton.setTextColor(Color.GREEN);
            SharedPreferences internalPrefs= PreferenceManager.getDefaultSharedPreferences(this);
            internalPrefs.edit().putString("question",questionText.getText().toString()).apply();
            clearTextBox();
        }else{
            setQuestionButton.setTextColor(Color.RED);
        }
        setQuestionButton.animate().setDuration(1000).withEndAction(new Runnable() {
            @Override
            public void run() {
                setQuestionButton.setTextColor(Color.WHITE);

            }
        }).start();
    }
}