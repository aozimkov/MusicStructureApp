package com.example.android.musicstructureapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SongActivity extends AppCompatActivity {

    boolean isPlay;
    int songID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        String intentSongName = getIntent().getStringExtra("EXTRA_SONG_NAME");
        String intentSongAuthor = getIntent().getStringExtra("EXTRA_SONG_AUTHOR");
        String intentSongDescription = getIntent().getStringExtra("EXTRA_SONG_DESCRIPTION");
        int intentSongImage = getIntent().getIntExtra("EXTRA_SONG_IMAGE", 0);
        songID = getIntent().getIntExtra("EXTRA_SONG_ID", 0);
        String intentSongTime = getIntent().getStringExtra("EXTRA_SONG_TIME");

        boolean intentIsPlay = getIntent().getBooleanExtra("EXTRA_PLAY_STATUS", false);
        isPlay = intentIsPlay;

        isPlay = !(isPlay);

        TextView songName = (TextView)findViewById(R.id.song_name);
        songName.setText(intentSongName);

        TextView songAuthor = (TextView)findViewById(R.id.song_author);
        songAuthor.setText(intentSongAuthor);

        TextView songTime = (TextView) findViewById(R.id.song_time);
        songTime.setText(intentSongTime);

        ImageView songImage = (ImageView)findViewById(R.id.song_image);
        songImage.setImageResource(intentSongImage);

        ImageView playButton = (ImageView)findViewById(R.id.song_play);
        switchPlayPause(isPlay);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isPlay = !(isPlay);
                switchPlayPause(isPlay);
            }
        });

    }


    @Override
    public void onBackPressed() {
        Intent backToMain = new Intent(this, MainActivity.class);
        backToMain.putExtra("EXTRA_PLAY_STATUS", isPlay);
        backToMain.putExtra("EXTRA_SONG_ID", songID);
        startActivity(backToMain);
    }

    public void switchPlayPause(boolean play){

        ImageView playButton = (ImageView)findViewById(R.id.song_play);

        if (play) {
            playButton.setImageResource(R.drawable.ic_pause_circle_filled);
        } else {
            playButton.setImageResource(R.drawable.ic_play_circle_filled);
        }
    }

}
