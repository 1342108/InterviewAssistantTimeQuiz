package com.example.android.interviewassistant;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class VideoPlayer extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener
{
    public static String currentPath; // The path in the current instance of this class

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

        new GetFromDatabase().execute(); // Async task to access database to get video path

        YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.playerVideoView);
        youTubeView.initialize(YoutubeDeveloperKey, this);
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

    private class GetFromDatabase extends AsyncTask<String,String,String>
    {

        @Override
        protected String doInBackground(String... params)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                // 1. get connection
                Connection myConnection = DriverManager.getConnection("jdbc:mysql://134.83.83.25:47000/grp2_interview_assistant", "l2grp2","l2grp2");

                // 2. create statement
                Statement myStatement = myConnection.createStatement();

                // 3. execute sql query
                ResultSet myResultSet = myStatement.executeQuery("SELECT * FROM VIDEOS");

                // 4. process the result set
                int id;
                while(myResultSet.next())
                {
                    id = myResultSet.getInt("v_id"); // gets current value of v_id

                    // if the position of ListView is = to the video ID then get the video path and set currentPath to its value
                    if(VideosList.vPosition == id)
                    {
                        currentPath = myResultSet.getString("v_path").trim();
                        break;
                    }
                }
                myConnection.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return currentPath;
        }
    }
}