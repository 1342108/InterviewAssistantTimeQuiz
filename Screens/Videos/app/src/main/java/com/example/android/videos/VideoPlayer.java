package com.example.android.videos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class VideoPlayer extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener {

    // These are for the sake of the screens working, this is NOT the final product. Database connection needed.
    private VideoData[] videoInfo = new VideoData[6]; // Storing the VideoData class info into an array
    private String currentPath = ""; // The path in the current instance of this class

    private YouTubePlayer YPlayer;

    // Developer stuff
    private static final String YoutubeDeveloperKey = "AIzaSyCZ9_aMpzA-V6wcHGuVKpSHEPWK1o0Gj5g";
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_video_player);

        YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.playerVideoView);
        youTubeView.initialize(YoutubeDeveloperKey, this);

        // Assign the video titles to the link that corresponds to the video
        videoInfo[0] = new VideoData("5 Body Language Tips for your Next Job Interview", "4o7GtD6KuZU");
        videoInfo[1] = new VideoData("6 Tips for the Best Body Language in Interviews #WisdomWednesday", "JyxGSnQCSl8");
        videoInfo[2] = new VideoData("7 body language tips to impress at your next job interview", "PCWVi5pAa30");
        videoInfo[3] = new VideoData("Job Interview Tips - How to Prepare for a Job Interview", "0p_A2P_uvzc");
        videoInfo[4] = new VideoData("Job Interview Tips - Job Interview Questions and Answers", "epcc9X1aS7o");
        videoInfo[5] = new VideoData("Interviewing and Selling Yourself", "yVE4s7lU-zE");

        Intent mainActivity = getIntent(); // Gets the intent from MainActivity
        String title = mainActivity.getStringExtra("title"); // Gets the title from the ListView that we added with the intent in MainActivity

        // Iterates through the array to find the same title
        for (int i = 0; i < videoInfo.length; i++) {
            if (title.equals(videoInfo[i].getTitle())) {
                currentPath = videoInfo[i].getVideoPath();
                break;
            }
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        YPlayer = player;

        /**
         * Now that this variable YPlayer is global you can access it
         * throughout the activity, and perform all the player actions like
         * play, pause and seeking to a position by code.
         */
        if (!wasRestored) {
            YPlayer.cueVideo(currentPath); // Play the video
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    "There was an error initializing the YouTubePlayer",
                    errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(YoutubeDeveloperKey, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.playerVideoView);
    }
}
