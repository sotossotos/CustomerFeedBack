package com.example.customerfeedback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    Button setButton;
    Button feedbackButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);
        setButton=(Button) findViewById(R.id.setQuestionButton);
        feedbackButton=(Button)findViewById(R.id.feedbackButton);
        feedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFeedbackActivity();
            }
        });
        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionActivity();

            }
        });

    }
    public void openFeedbackActivity(){
        Intent intent = new Intent(this, FeedbackActivity.class);
        startActivity(intent);
    }
    public void opeQuestionSetting(){
        Intent intent = new Intent(this, SetQuestionActivity.class);
        startActivity(intent);
    }
    public void openQuestionActivity(){
        LayoutInflater inf=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        ConstraintLayout relativeLayout=(ConstraintLayout)findViewById(R.id.constraint);
        ViewGroup popUp=(ViewGroup)inf.inflate(R.layout.pop_code,null);
        PopupWindow popWindow= new PopupWindow(popUp,800,800,true);

        popWindow.showAtLocation(relativeLayout, Gravity.CENTER,1,1);
        TextView userCode=(TextView)popUp.findViewById(R.id.editTextNumberPassword);
        Button enterCodeButton=(Button) popUp.findViewById(R.id.enterCodeButton);
        enterCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userCode.getText().toString().equals(getResources().getString(R.string.admin_code))){
                    Intent intent = new Intent(MainActivity.this, SetQuestionActivity.class);
                    startActivity(intent);
                    popWindow.dismiss();
                    Log.d("The password check","SUCCESS");

                }else{
                    userCode.setText("");
                }

            }
        });
        popUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popWindow.dismiss();
                return true;
            }
        });

        //Intent intent = new Intent(this, SetQuestionActivity.class);
        //startActivity(intent);
    }

}