package com.example.android.musicstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {

    boolean isPlay;
    int songID;

    TextView songName;
    TextView songAuthor;
    TextView songAlbum;
    TextView songTime;
    ImageView songImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        final ArrayList<Song> rec = new ArrayList<Song>();

        rec.add(new Song(0, "Forgotten space cookies", "Dark Invader", "The Content", R.drawable.track1, false, "04:15", true ));
        rec.add(new Song(2, "Trip to Bangladesh (Psychedelic Progressive Mix)", "Kurash Kurash", "Kurash", R.drawable.track3, false, "03:11", true ));
        rec.add(new Song(4, "Narramnayan", "Shivat Achieved", "Shivat Achieved", R.drawable.track5, false, "01:35",true ));
        rec.add(new Song(7, "Untitled", "Untitled", "Untitled", R.drawable.track8, false, "02:07", true));
        rec.add(new Song(9, "Forgotten space cookies", "Dark Invader", "The Content", R.drawable.track1, false, "04:15", true ));
        rec.add(new Song(11, "Trip to Bangladesh (Psychedelic Progressive Mix)", "Kurash Kurash", "Kurash", R.drawable.track3, false, "03:11", true ));
        rec.add(new Song(13, "Narramnayan", "Shivat Achieved", "Shivat Achieved", R.drawable.track5, false, "01:35",true ));
        rec.add(new Song(16, "Untitled", "Untitled", "Untitled", R.drawable.track8, false, "02:07", true));


        String intentSongName = getIntent().getStringExtra("EXTRA_SONG_NAME");
        String intentSongAuthor = getIntent().getStringExtra("EXTRA_SONG_AUTHOR");
        String intentSongAlbum = getIntent().getStringExtra("EXTRA_SONG_ALBUM");
        int intentSongImage = getIntent().getIntExtra("EXTRA_SONG_IMAGE", 0);
        songID = getIntent().getIntExtra("EXTRA_SONG_ID", 0);
        String intentSongTime = getIntent().getStringExtra("EXTRA_SONG_TIME");

        boolean intentIsPlay = getIntent().getBooleanExtra("EXTRA_PLAY_STATUS", false);
        isPlay = intentIsPlay;

        songName = (TextView)findViewById(R.id.song_name);
        songName.setText(intentSongName);

        songAuthor = (TextView)findViewById(R.id.song_author);
        songAuthor.setText(intentSongAuthor);

        String Album = getString(R.string.album, intentSongAlbum);
        songAlbum = (TextView)findViewById(R.id.song_album);
        songAlbum.setText(Album);

        songTime = (TextView) findViewById(R.id.song_time);
        songTime.setText(intentSongTime);

        songImage = (ImageView) findViewById(R.id.song_image);
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

        RecommendedAdapter adapter = new RecommendedAdapter(this, rec);
        ListView listView = (ListView) findViewById(R.id.list_recommended);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                songName.setText(rec.get(i).getmSongName());
                songAuthor.setText(rec.get(i).getmSongAuthor());
                songAlbum.setText(getString(R.string.album, rec.get(i).getmSongAlbum()));
                songTime.setText(rec.get(i).getmSongTime());
                songImage.setImageResource(rec.get(i).getmSongImage());

                songID = rec.get(i).getmId();

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
