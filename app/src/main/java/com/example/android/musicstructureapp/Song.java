package com.example.android.musicstructureapp;


public class Song {

    private String mSongName;
    private String mSongAuthor;
    private String mSongDescription;
    private int mSongImage;
    private boolean mPlayStatus;
    private String mSongTime;


    /**
     * full constructor for Song View
     *
     * @param songName Title of the track
     * @param songAuthor Author name
     * @param songImage Song image
     * @param playStatus Status of playing. If song plays now - true
     * @param songDescription Text Description for Song
     * @param songTime Song duration
     */
    public Song(String songName, String songAuthor, String songDescription, int songImage, boolean playStatus, String songTime) {
        this.mSongName = songName;
        this.mSongAuthor = songAuthor;
        this.mSongDescription = songDescription;
        this.mSongImage = songImage;
        this.mPlayStatus = playStatus;
        this.mSongTime = songTime;
    }

    /**
     * Constructor for Songs list
     *
     * @param mSongName
     * @param mSongAuthor
     * @param mSongImage
     */
    public Song(String mSongName, String mSongAuthor, int mSongImage, boolean mPlayStatus, String songTime) {
        this.mSongName = mSongName;
        this.mSongAuthor = mSongAuthor;
        this.mSongImage = mSongImage;
        this.mPlayStatus = mPlayStatus;
        this.mSongTime = songTime;
    }

    public String getmSongName() {
        return mSongName;
    }

    public String getmSongAuthor() {
        return mSongAuthor;
    }

    public String getmSongDescription() {
        return mSongDescription;
    }

    public int getmSongImage() {
        return mSongImage;
    }

    public boolean isPlay() {
        return mPlayStatus;
    }

    public String getmSongTime() {
        return mSongTime;
    }

    public void setmPlayStatus(boolean mPlayStatus) {
        this.mPlayStatus = mPlayStatus;
    }
}
