package com.example.android.videos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;


public class VideoPlayer extends AppCompatActivity {

    ImageButton iButton;
    VideoView video;
    MediaController mediaC; // Adds things you'd find on a video player e.g. timeline, play/pause buttons

    private VideoData[] videoInfo = new VideoData[6]; // Using VideoData class to initialise an array of size 6 to contain all videos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_language1);
        iButton = (ImageButton) findViewById(R.id.playButton);
        video = (VideoView) findViewById(R.id.bodyLanguage1VideoView);
        mediaC = new MediaController(this);

        /**
         * adding title and paths to mp4 files
         */
        videoInfo[0] = new VideoData("5 Body Language Tips for your Next Job Interview","android.resource://com.example.android.videos/"+R.raw.body_language1);
        videoInfo[1] = new VideoData("6 Tips for the Best Body Language in Interviews #WisdomWednesday","android.resource://com.example.android.videos/"+R.raw.body_language2);
        videoInfo[2] = new VideoData("7 body language tricks to ace your next job interview","android.resource://com.example.android.videos/"+R.raw.body_language3);
        videoInfo[3] = new VideoData("Interviewing and Selling Yourself","android.resource://com.example.android.videos/"+R.raw.interview1);
        videoInfo[4] = new VideoData("Job Interview Tips - How to Prepare for a Job Interview","android.resource://com.example.android.videos/"+R.raw.interview2);
        videoInfo[5] = new VideoData("Job Interview Tips - Job Interview Questions and Answers","android.resource://com.example.android.videos/"+R.raw.interview3);

        Intent mainActivity = getIntent(); // Gets the intent established in MainActivity.java

        String title = mainActivity.getStringExtra("title"); // Gets the title from what was clicked on the ListView

        /**
         * Finds the video title corresponding to what was clicked on the ListView
         */
        for(int i = 0;i<videoInfo.length;i++) {
            if(title.equals(videoInfo[i].getTitle())) {
                setVideo(videoInfo[i]);
                break;
            }
        }
    }

    /**
     * Sets up the video before it is played
     * @param videoData will be used to call the getVideoPath method in the VideoData class
     */
    private void setVideo(VideoData videoData){
        Uri uri = Uri.parse(videoData.getVideoPath()); // Uniform Resource Identifier - accepts a string of chars used to identify the resource
        video.setVideoURI(uri); // Finds the video using the uri variable containing the path to the video
        video.setMediaController(mediaC);
        mediaC.setAnchorView(video);
        video.seekTo(1000); // Thumbnail set before video is played
    }

    /**
     * Plays the video when play button is clicked
     */
    public void playVideo(View v)
    {
        iButton.setVisibility(View.GONE); // Button disappears after it is pressed
        video.start();
    }
}
