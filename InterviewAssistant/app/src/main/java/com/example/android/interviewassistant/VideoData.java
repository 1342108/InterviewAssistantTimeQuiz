package com.example.android.interviewassistant;

/**
 * Created by Samin on 19/01/2017.
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
