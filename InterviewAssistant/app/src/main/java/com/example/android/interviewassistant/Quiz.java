package com.example.android.interviewassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Quiz extends AppCompatActivity {

    private QuizQuestionLibrary mQuizQuestionLibrary = new QuizQuestionLibrary();

    private TextView mQuestionView;
    private ImageView mImageView;
    private TextView qNumberView;
    private Button mAnswerA;
    private Button mAnswerB;
    private Button mAnswerC;
    private Button mAnswerD;


    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quiz);

        //mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.mQuestionView);
        qNumberView = (TextView)findViewById(R.id.qNumberView);
        mAnswerA = (Button) findViewById(R.id.mAnswerA);
        mAnswerB = (Button) findViewById(R.id.mAnswerB);
        mAnswerC = (Button) findViewById(R.id.mAnswerC);
        mAnswerD = (Button) findViewById(R.id.mAnswerD);



        updateQuestion();

        //Start of Button Listener for Answer A
        mAnswerA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                if(mAnswerA.getText() == mAnswer)
                {
                    mScore = mScore + 1;
                    updateQuestion();
                }
                else
                {
                    mScore = mScore - 1;
                    updateQuestion();
                }
            }
        });
        //End of Button Listener for Answer A

        //Start of Button Listener for Answer B
        mAnswerB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                if(mAnswerB.getText() == mAnswer)
                {
                    mScore = mScore + 1;
                    updateQuestion();
                }
                else
                {
                    mScore = mScore - 1;
                    updateQuestion();
                }
            }
        });
        //End of Button Listener for Answer B

        //Start of Button Listener for Answer C
        mAnswerC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                if(mAnswerC.getText() == mAnswer)
                {
                    mScore = mScore + 1;
                    updateQuestion();
                }
                else
                {
                    mScore = mScore - 1;
                    updateQuestion();
                }

            }
        });
        //End of Button Listener for Answer C

        //Start of Button Listener for Answer D
        mAnswerD.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                if(mAnswerD.getText() == mAnswer)
                {
                    mScore = mScore + 1;
                    updateQuestion();
                }
                else
                {
                    mScore = mScore - 1;
                    updateQuestion();
                }

            }
        });
        //End of Button Listener for Answer D
    }

    private void updateQnumber()
    {
        qNumberView.setText("" + mQuestionNumber);
    }
    private void updateQuestion()
    {
        mQuestionView.setText(mQuizQuestionLibrary.getQuestion(mQuestionNumber));
        mAnswerA.setText(mQuizQuestionLibrary.getAnswerA(mQuestionNumber));
        mAnswerB.setText(mQuizQuestionLibrary.getAnswerB(mQuestionNumber));
        mAnswerC.setText(mQuizQuestionLibrary.getAnswerC(mQuestionNumber));
        mAnswerD.setText(mQuizQuestionLibrary.getAnswerD(mQuestionNumber));


        mAnswer = mQuizQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;
        updateQnumber();

    }
}
