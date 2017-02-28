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
    // List of video titles
    String[] videoTitles = {"5 Body Language Tips for your Next Job Interview",
            "6 Tips for the Best Body Language in Interviews #WisdomWednesday",
            "7 body language tips to impress at your next job interview",
            "Interviewing and Selling Yourself",
            "Job Interview Tips - How to Prepare for a Job Interview",
            "Job Interview Tips - Job Interview Questions and Answers",};
    ListView lv;

    public static int vPosition; // position of ListView item that was clicked on

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        // Finds the ListView in the xml layout and uses the ArrayAdapter to set the video titles to a default list layout
        lv = (ListView) findViewById(R.id.videoTitleListView);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, videoTitles);
        lv.setAdapter(adapter);

        // This finds the particular item that was clicked on the list
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                vPosition = position+1; // +1 to compensate for v_id table in database starting from 1

                // Moves from ListView page to video
                Intent goToVideoPlayer = new Intent(MainActivity.this, VideoPlayer.class);
                //goToVideoPlayer.putExtra("position", vPosition); // Gets the title of the video from what was in the ListView at position X
                startActivity(goToVideoPlayer);
            }
        });
    }
}
