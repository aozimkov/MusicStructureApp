package com.example.android.musicstructureapp;


import android.support.annotation.NonNull;

public class Song {

    private int mId;
    private String mSongName;
    private String mSongAuthor;
    private String mSongAlbum;
    private int mSongImage;
    private boolean mPlayStatus;
    private String mSongTime;
    private boolean mRecommended;


    /**
     * full constructor for Song View
     *
     * @param songName Title of the track
     * @param songAuthor Author name
     * @param songImage Song image
     * @param playStatus Status of playing. If song plays now - true
     * @param songAlbum Text Description for Song
     * @param songTime Song duration
     */
    public Song(int id, String songName, String songAuthor, String songAlbum, int songImage, boolean playStatus, String songTime, boolean recommended) {
        this.mId = id;
        this.mSongName = songName;
        this.mSongAuthor = songAuthor;
        this.mSongAlbum = songAlbum;
        this.mSongImage = songImage;
        this.mPlayStatus = playStatus;
        this.mSongTime = songTime;
        this.mRecommended = recommended;
    }


    public int getmId() {
        return mId;
    }

    public String getmSongName() {
        return mSongName;
    }

    public String getmSongAuthor() {
        return mSongAuthor;
    }

    public String getmSongAlbum() {
        return mSongAlbum;
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

    public void setPause() {
        this.mPlayStatus = false;
    }


}
