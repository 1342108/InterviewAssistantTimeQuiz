package com.example.android.interviewassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.Arrays;

public class MainActivityHomepage extends Activity implements TextWatcher {

    AutoCompleteTextView act;
    String[] skills = {"Adaptability", "Creativity", "Teamwork", "Responsibility",
            "Commercial awareness", "Decision making", "Career motivation", "Communication",
            "Leadership", "Trustworthiness", "Problem solving", "Organisation",
            "Initiative", "Self motivation", "Client focus", "Attention to detail",
            "Meeting standards", "Persuading others", "Results orientation", "Strengths",
            "Weaknesses", "Analytical", "Responding to change", "Versatility"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_homepage);
        Arrays.sort(skills);

        act = (AutoCompleteTextView) findViewById(R.id.searchAutoCompleteTextView);
        act.addTextChangedListener(this);
        act.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, skills));
    }

    public void goToBrowseAll(View view)
    {
        Intent nextPage = new Intent(MainActivityHomepage.this, AllSkills.class);
        startActivity(nextPage);
    }

    public void goToQuiz(View view)
    {
        Intent nextPage = new Intent(MainActivityHomepage.this, MainActivityQuiz.class);
        startActivity(nextPage);
    }

    public void goToSettings(View view)
    {
        Intent nextPage = new Intent(MainActivityHomepage.this, AllSkills.class);
        startActivity(nextPage);
    }

    public void goToPractice(View view)
    {
        Intent nextPage = new Intent(MainActivityHomepage.this, AllSkills.class);
        startActivity(nextPage);
    }

    public void goToVideos(View view)
    {
        Intent nextPage = new Intent(MainActivityHomepage.this, MainActivityVideos.class);
        startActivity(nextPage);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable arg0) {

    }
}
