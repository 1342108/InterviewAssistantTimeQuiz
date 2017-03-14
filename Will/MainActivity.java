package com.example.cs15wau.questions;

/**
 * Created by cs15wau on 15/02/2017.
 */
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

   public static String answer = "";
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
        new Answers().execute();

            }


    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data. Copy this line and paste it below to add name of heading
        listDataHeader.add("Question 1");
        listDataHeader.add("2.\tHow do you respond to change?");
        listDataHeader.add("3.\tTell me about a time you had to quickly adjust your work priorities to meet changing demands");




        //Copy the line below and paste below last line
        //Change "questions" to appropriate variable name
        List<String> answerA = new ArrayList<String>();

        //Copy this line and paste it below to add another subheaing
        answerA.add(answer);// Change "Subheading #" to desired subheading


        List<String> answerB = new ArrayList<String>();

        answerB.add("Example Answer:\n" +
                "I believe I can adapt to changes in any circumstances. Every organisation is different to one another and job roles may vary but I believe the core requirements of my role do not change. I understand that there will be new procedures that I will have to follow, I also understand how important it is to forming good working relations with new colleagues. However, I know this will not take very long as due to my previous experiences in my past jobs, I’ve always been a fast learner. \n"+"\n" +
                "Tips:\n" +
                "•\tAlso talk about a previous job, where you were able to settle in quickly and had great relationships with your colleagues. \n"+"\n" +
                "•\tExplain how you were able to understand the way the organisation worked after a short while\n");



        List<String> answerC = new ArrayList<String>();


        answerC.add("Tips:  \n" +
                "•\tThe interviewer wants to know whether you are able to perform in different environments and with different tasks, people and responsibilities, give an example of a time you have adjusted your actions to meet changing demands and tasks.\n" +"\n"+
                "•\tWhen answering this question, the STAR approach should be followed:\n" +"\n"+
                "Situation: Describe the situation\n" +
                "Task: What task were you given?\n" +
                "Action: What action did you take?\n" +
                "Result: What was the end result? \n");

        //Copy and paste the line below under itself and replace the number in the brackets
        //to the corresponding heading (0 = heading 1, 1 = heading 2...etc.) AND
        //change the "questions" to corresponding subheading
        listDataChild.put(listDataHeader.get(0), answerA);
        listDataChild.put(listDataHeader.get(1), answerB);
        listDataChild.put(listDataHeader.get(2), answerC);

    }

    private class Answers extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
            // 1. Get a connection to database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://134.83.83.25:47000/grp2_interview_assistant", "l2grp2", "l2grp2");

            // 2. Create a statement
            Statement myStmt = myConn.createStatement();
                listDataHeader = new ArrayList<String>();
            // 3. Execute SQL query
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM ANSWERS WHERE  answer_id =1");
          //  + "(q_text, q_correct_answer,q_choice_text)"
          //  + " values ('Hi', 2,'hi')");
           //  String sql="insert into QUIZ_DATA "
               //         + " (q_text, q_correct_answer, q_choice_text) "
                 //       + " values ('Hi', 2, 'hi')";
          //     myStmt.executeUpdate(sql);


            // 4. Process the result set
            while (myRs.next()) {
               answer = myRs.getString("answer");
               System.out.println(myRs.getString(answer));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

            return null;
        }
    }

}
