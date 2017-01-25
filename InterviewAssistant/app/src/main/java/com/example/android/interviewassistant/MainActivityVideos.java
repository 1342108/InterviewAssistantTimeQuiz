package com.example.android.interviewassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivityVideos extends AppCompatActivity {

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
        setContentView(R.layout.activity_videos);

        lv = (ListView) findViewById(R.id.videoTitleListView);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, videoTitles);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                /**
                 * Moves from ListView page to video
                 */
                Intent random = new Intent(MainActivityVideos.this, VideoPlayer.class);
                random.putExtra("title",videoTitles[position]); // Gets the title of the video from what was in the ListView at position X
                startActivity(random);
            }
        });
    }
}
