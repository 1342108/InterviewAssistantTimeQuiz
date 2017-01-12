package com.example.android.videos;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class Interview3 extends AppCompatActivity {
    ImageButton iButton;
    VideoView video;
    MediaController mediaC; // Adds things you'd find on a video player e.g. timeline, play/pause buttons
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview3);
        iButton = (ImageButton) findViewById(R.id.playButton);
        video = (VideoView) findViewById(R.id.bodyLanguage1VideoView);
        mediaC = new MediaController(this);
    }
    /**
     * Plays the video when play button is clicked
     */
    public void playVideo(View v)
    {
        iButton.setVisibility(View.GONE); // Button disappears after it is pressed
        Uri uri = Uri.parse("android.resource://com.example.android.videos/"+R.raw.interview3); // Uniform Resource Identifier - accepts a string of chars used to identify the resource
        video.setVideoURI(uri); // Finds the video using the uri variable containing the path to the video
        video.setMediaController(mediaC);
        mediaC.setAnchorView(video);
        video.seekTo(1000); // Thumbnail set before video is played
        video.start();
    }
}
