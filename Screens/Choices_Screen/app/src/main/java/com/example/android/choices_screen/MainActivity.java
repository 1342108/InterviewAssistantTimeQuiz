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

        // Adding child data. Copy this line and paste it below to add name of heading
        listDataHeader.add("Heading 1");// Change "Heading 1" to desired heading


        //Copy the line below and paste below last line
        //Change "questions" to appropriate variable name
        List<String> questions = new ArrayList<String>();


        //Copy this line and paste it below to add another subheaing
        questions.add("Subheading 1");// Change "Subheading #" to desired subheading


        //Copy and paste the line below under itself and replace the number in the brackets
        //to the corresponding heading (0 = heading 1, 1 = heading 2...etc.) AND
        //change the "questions" to corresponding subheading
        listDataChild.put(listDataHeader.get(0), questions);


    }
}
