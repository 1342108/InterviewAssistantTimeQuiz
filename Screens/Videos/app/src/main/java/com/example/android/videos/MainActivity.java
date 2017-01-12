package com.example.android.videos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Main class where there is a list of video titles which the user can click on one
 */
public class MainActivity extends AppCompatActivity {

    String[] videoTitles = {"5 Body Language Tips for your Next Job Interview",
            "6 Tips for the Best Body Language in Interviews #WisdomWednesday",
            "7 body language tricks to ace your next job interview",
            "Interviewing and Selling Yourself",
            "Job Interview Tips - How to Prepare for a Job Interview",
            "Job Interview Tips - Job Interview Questions and Answers",};
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.videoTitleListView);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, videoTitles);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int itemPosition = position; // Each item in ListView


                switch(itemPosition) { // Each case takes to corresponding video (could be inefficient if more videos added. Any different ideas?)

                    case 0:
                        Intent intent = new Intent(MainActivity.this, BodyLanguage1.class);
                        startActivity(intent);
                        break;

                    case 1:
                        Intent intent1 = new Intent(MainActivity.this, BodyLanguage2.class);
                        startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2 = new Intent(MainActivity.this, BodyLanguage3.class);
                        startActivity(intent2);
                        break;

                    case 3:
                        Intent intent3 = new Intent(MainActivity.this, Interview1.class);
                        startActivity(intent3);
                        break;

                    case 4:
                        Intent intent4 = new Intent(MainActivity.this, Interview2.class);
                        startActivity(intent4);
                        break;

                    case 5:
                        Intent intent5 = new Intent(MainActivity.this, Interview3.class);
                        startActivity(intent5);
                        break;
                }
            }
        });
    }
}
