package com.example.android.musicstructureapp;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("Track 1", "Author 1", "Track description", R.drawable.track1, false, "04:15" ));
        songs.add(new Song("Track 2", "Author 2", "Track description", R.drawable.track2, false, "02:01" ));
        songs.add(new Song("Track 3", "Author 3", "Track description", R.drawable.track3, false, "03:11" ));
        songs.add(new Song("Track 4", "Author 4", "Track description", R.drawable.track4, false, "04:55" ));
        songs.add(new Song("Track 5", "Author 5", "Track description", R.drawable.track5, false, "01:35" ));
        songs.add(new Song("Track 6", "Author 6", "Track description", R.drawable.track6, false, "05:23" ));
        songs.add(new Song("Track 7", "Author 7", "Track description", R.drawable.track7, false, "07:42" ));
        songs.add(new Song("Track 8", "Author 8", "Track description", R.drawable.track8, false, "02:07" ));
        songs.add(new Song("Track 9", "Author 9", "Track description", R.drawable.track9, false, "04:11" ));

        if(getIntent().hasExtra("EXTRA_SONG_ID")){

            int songID = getIntent().getIntExtra("EXTRA_SONG_ID", 0);
            boolean songIsPlay = getIntent().getBooleanExtra("EXTRA_PLAY_STATUS", false);
            Song currentSong = songs.get(songID);
            currentSong.setmPlayStatus(songIsPlay);
        }


        SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent openSongIntent = new Intent(MainActivity.this, SongActivity.class);
                openSongIntent.putExtra("EXTRA_SONG_ID", i);
                openSongIntent.putExtra("EXTRA_SONG_NAME", songs.get(i).getmSongName());
                openSongIntent.putExtra("EXTRA_SONG_AUTHOR", songs.get(i).getmSongAuthor());
                openSongIntent.putExtra("EXTRA_SONG_DESCRIPTION", songs.get(i).getmSongDescription());
                openSongIntent.putExtra("EXTRA_SONG_IMAGE", songs.get(i).getmSongImage());
                openSongIntent.putExtra("EXTRA_PLAY_STATUS", songs.get(i).isPlay());
                openSongIntent.putExtra("EXTRA_SONG_TIME", songs.get(i).getmSongTime());

                startActivity(openSongIntent);
            }
        });

    }
}
