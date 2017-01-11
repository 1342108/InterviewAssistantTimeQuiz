package com.example.android.quiz_screen;

public class QuestionLibrary {

    private String questions [] =
            {
                    "What is your favourite food?",
                    "Is the sky blue?",
                    "Is this a valid quesiton?",
                    "What does 2 + 2 equal?"
            };
    private String choices [][] =
            {
                    {"KFC", "McDonalds","5 Guys","Nandos"},
                    {"Yes","No","I don't know","Maybe"},
                    {"No!","Yes!","Maybe!","Really?!"},
                    {"22","4","0","1"}
            };
    private String CorrectAnswers[] = {"Nandos", "Yes","Yes","4"};

    private String getQuestion (int a)
    {
        String question = questions[a];
        return question;
    }

    public String getChoiceA (int a)
    {
        String choice0 = choices[a][0];
        return choice0;
    }

    public String getChoiceB (int a)
    {
        String choice1 = choices[a][1];
        return choice1;
    }

    public String getChoiceC (int a)
    {
        String choice2 = choices[a][2];
        return choice2;
    }

    public String getChoiceD (int a)
    {
        String choice3 = choices[a][3];
        return choice3;
    }

    public String getCorrectAnswer (int a)
    {
        String answer = CorrectAnswers[a];
        return answer;
    }
}
