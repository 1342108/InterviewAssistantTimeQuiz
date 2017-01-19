package com.example.android.homepagev3;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class AllSkills extends Activity {

    String skills[] = {"Adaptability", "Creativity", "Teamwork", "Responsibility",
            "Commercial awareness", "Decision making", "Career motivation", "Communication",
            "Leadership", "Trustworthiness", "Problem solving", "Organisation",
            "Initiative", "Self motivation", "Client focus", "Attention to detail",
            "Meeting standards", "Persuading others", "Results orientation", "Strengths",
            "Weaknesses", "Analytical", "Responding to change", "Versatility"};
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_all_skills);
        Arrays.sort(skills);
        lv = (ListView) findViewById(R.id.skillsListView);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, skills);
        lv.setAdapter(adapter);
    }
}