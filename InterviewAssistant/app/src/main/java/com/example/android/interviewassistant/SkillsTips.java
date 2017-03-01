package com.example.android.interviewassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.R.id.list;

public class SkillsTips extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills_tips);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new SkillsELAdapter(this,listDataHeader,listDataChild); {
        }

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
        listDataHeader.add("1.\tHow do you go about handling difficult people?");// Change "Heading 1" to desired heading
        listDataHeader.add("2.\tHow do you respond to change?");
        listDataHeader.add("3.\tTell me about a time you had to quickly adjust your work priorities to meet changing demands");

        //Copy the line below and paste below last line
        //Change "questions" to appropriate variable name
        List<String> Adap = new ArrayList<String>();

        //Copy this line and paste it below to add another subheaing
        Adap.add("•\tTalk about a time you have had to deal with difficult colleagues, colleagues who may have failed to complete the work or have an unprofessional attitude.\n"+"\n" +
                "•\tExplain in detail the actions you took, for example good communication is essential in a situation like this.\n"+"\n" +
                "•\tExplain how important it is to always remain calm and positive in this situation, it’s important to try and understand them which will help in finding ways to work through any of the difficulties.\n");// Change "Subheading #" to desired subheading


        List<String> questions2 = new ArrayList<String>();

        questions2.add("Example Answer:\n" +
                "I believe I can adapt to changes in any circumstances. Every organisation is different to one another and job roles may vary but I believe the core requirements of my role do not change. I understand that there will be new procedures that I will have to follow, I also understand how important it is to forming good working relations with new colleagues. However, I know this will not take very long as due to my previous experiences in my past jobs, I’ve always been a fast learner. \n"+"\n" +
                "Tips:\n" +
                "•\tAlso talk about a previous job, where you were able to settle in quickly and had great relationships with your colleagues. \n"+"\n" +
                "•\tExplain how you were able to understand the way the organisation worked after a short while\n");



        List<String> questions3 = new ArrayList<String>();


        questions3.add("Tips:  \n" +
                "•\tThe interviewer wants to know whether you are able to perform in different environments and with different tasks, people and responsibilities, give an example of a time you have adjusted your actions to meet changing demands and tasks.\n" +"\n"+
                "•\tWhen answering this question, the STAR approach should be followed:\n" +"\n"+
                "Situation: Describe the situation\n" +
                "Task: What task were you given?\n" +
                "Action: What action did you take?\n" +
                "Result: What was the end result? \n");

        //Copy and paste the line below under itself and replace the number in the brackets
        //to the corresponding heading (0 = heading 1, 1 = heading 2...etc.) AND
        //change the "questions" to corresponding subheading
        listDataChild.put(listDataHeader.get(0), Adap);
        listDataChild.put(listDataHeader.get(1), questions2);
        listDataChild.put(listDataHeader.get(2), questions3);
    }
}
