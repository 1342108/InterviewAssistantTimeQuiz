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

                /**
                 * Moves from ListView page to video
                 */
                Intent random = new Intent(MainActivity.this,VideoPlayer.class);
                random.putExtra("title",videoTitles[position]); // Gets the title of the video from what was in the ListView at position X
                startActivity(random);

//
            }
        });
    }
}
