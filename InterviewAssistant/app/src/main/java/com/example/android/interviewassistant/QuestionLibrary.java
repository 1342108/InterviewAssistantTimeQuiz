package com.example.android.interviewassistant;

/**
 * Created by Samin on 19/01/2017.
 */

public class QuestionLibrary {
    private String mQuestions [] =
            {
                    "What colour is the box above?",
                    "How many boxes are displayed above?",
                    "Is the sky blue?"
};

    private String mChoices [][] =
            {
                    {"Black","Yellow","Blue","Green"},
                    {"1","2","3","4"},
                    {"Yes","No","Really!?","Hell yes!"}
            };

    private String mCorrectAnswers[] = {"Black", "2", "Yes"};

    public String getQuestion(int a)
    {
        String question = mQuestions[a];
        return question;
    }

    public String getAnswerA(int a)
    {
        String choiceA = mChoices[a][0];
        return choiceA;
    }

    public String getAnswerB(int a)
    {
        String choiceB = mChoices[a][1];
        return choiceB;
    }

    public String getAnswerC(int a)
    {
        String choiceC = mChoices[a][2];
        return choiceC;
    }

    public String getAnswerD(int a)
    {
        String choiceD = mChoices[a][3];
        return choiceD;
    }

    public String getCorrectAnswer (int a)
    {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
