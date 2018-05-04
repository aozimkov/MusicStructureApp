package com.example.android.musicstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song(0, "Forgotten space cookies", "Dark Invader", "The Content", R.drawable.track1, false, "04:15", true ));
        songs.add(new Song(1, "Near but so far", "Violetta G. Dublin", "Singles", R.drawable.track2, false, "02:01", false ));
        songs.add(new Song(2, "Trip to Bangladesh (Psychedelic Progressive Mix)", "Kurash Kurash", "Kurash", R.drawable.track3, false, "03:11", true ));
        songs.add(new Song(3, "Ouekko", "Ethnic Vibes", "Chili", R.drawable.track4, false, "04:55", false ));
        songs.add(new Song(4, "Narramnayan", "Shivat Achieved", "Shivat Achieved", R.drawable.track5, false, "01:35",true ));
        songs.add(new Song(5, "Out of bounds", "DJ Pedro Gulli", "Promo", R.drawable.track6, false, "05:23",false ));
        songs.add(new Song(6, "Colors", "Positive Guitars", "Colors", R.drawable.track7, false, "07:42", false));
        songs.add(new Song(7, "Untitled", "Untitled", "Untitled", R.drawable.track8, false, "02:07", true));
        songs.add(new Song(8, "Gangsta cry", "P.D. BackBag", "Big Gun Man", R.drawable.track9, false, "04:11",false ));
        songs.add(new Song(9, "Forgotten space cookies", "Dark Invader", "The Content", R.drawable.track1, false, "04:15", true ));
        songs.add(new Song(10, "Near but so far", "Violetta G. Dublin", "Singles", R.drawable.track2, false, "02:01", false ));
        songs.add(new Song(11, "Trip to Bangladesh (Psychedelic Progressive Mix)", "Kurash Kurash", "Kurash", R.drawable.track3, false, "03:11", true ));
        songs.add(new Song(12, "Ouekko", "Ethnic Vibes", "Chili", R.drawable.track4, false, "04:55", false ));
        songs.add(new Song(13, "Narramnayan", "Shivat Achieved", "Shivat Achieved", R.drawable.track5, false, "01:35",true ));
        songs.add(new Song(14, "Out of bounds", "DJ Pedro Gulli", "Promo", R.drawable.track6, false, "05:23",false ));
        songs.add(new Song(15, "Colors", "Positive Guitars", "Colors", R.drawable.track7, false, "07:42", false));
        songs.add(new Song(16, "Untitled", "Untitled", "Untitled", R.drawable.track8, false, "02:07", true));
        songs.add(new Song(17, "Gangsta cry", "P.D. BackBag", "Big Gun Man", R.drawable.track9, false, "04:11",false ));

        if(getIntent().hasExtra("EXTRA_SONG_ID")){

            for(int i=0; i < songs.size(); i++ ){
                songs.get(i).setPause();
            }

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
                openSongIntent.putExtra("EXTRA_SONG_ALBUM", songs.get(i).getmSongAlbum());
                openSongIntent.putExtra("EXTRA_SONG_IMAGE", songs.get(i).getmSongImage());
                openSongIntent.putExtra("EXTRA_PLAY_STATUS", songs.get(i).isPlay());
                openSongIntent.putExtra("EXTRA_SONG_TIME", songs.get(i).getmSongTime());

                startActivity(openSongIntent);
            }
        });

    }

}
