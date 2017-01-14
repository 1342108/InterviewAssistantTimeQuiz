package com.example.android.videos;

/**
 * Created by Samin on 12/01/2017.
 */

/**
 * Keeps data about videos such as the title of the video and path to get to the mp4 files
 */
public class VideoData {

    private String title, videoPath;


    public VideoData(String title, String videoPath) {
        this.title = title;
        this.videoPath = videoPath;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
}
