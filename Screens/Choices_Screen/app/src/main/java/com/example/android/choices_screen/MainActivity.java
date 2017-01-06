package com.example.android.choices_screen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class MainActivity extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Questions");
        listDataHeader.add("Body Language");
        listDataHeader.add("Quiz");
        listDataHeader.add("Video Practice");

        // Adding child data
        List<String> questions = new ArrayList<String>();
        questions.add("Competency questions");
        questions.add("Technical questions");
        questions.add("Company questions");

        List<String> bodyLanguage = new ArrayList<String>();
        bodyLanguage.add("Good body language");
        bodyLanguage.add("Bad body language");
        bodyLanguage.add("Examples");

        List<String> quiz = new ArrayList<String>();
        quiz.add("Start quiz");
        quiz.add("Practice quiz");
        quiz.add("Previous results");


        List<String> videoPractice = new ArrayList<String>();
        videoPractice.add("Video practice 1");
        videoPractice.add("Video practice 2");
        videoPractice.add("Video practice 3");

        listDataChild.put(listDataHeader.get(0), questions); // Header, Child data
        listDataChild.put(listDataHeader.get(1), bodyLanguage);
        listDataChild.put(listDataHeader.get(2), quiz);
        listDataChild.put(listDataHeader.get(3), videoPractice);

        /*Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });*/
    }
}
