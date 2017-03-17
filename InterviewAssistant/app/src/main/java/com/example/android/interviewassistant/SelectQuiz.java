package com.example.android.interviewassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by usman on 17/03/2017.
 */

public class SelectQuiz extends  AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_quiz);
    }

    public void goToQuiz(View view)
    {
        Intent nextPage = new Intent(SelectQuiz.this, Quiz.class);
        startActivity(nextPage);
    }

    public void goToMainActivity(View view)
    {
        Intent nextPage = new Intent(SelectQuiz.this, MainActivity.class);
        startActivity(nextPage);
    }
}