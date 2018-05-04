package com.example.android.musicstructureapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song>{

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,
                    parent, false);
        }

        Song currentSong = getItem(position);


        TextView trackTitle = (TextView)listItemView.findViewById(R.id.track);
        trackTitle.setText(currentSong.getmSongName());

        TextView trackAlbum = (TextView)listItemView.findViewById(R.id.album);
        trackAlbum.setText(currentSong.getmSongAlbum());

        TextView trackAuthor = (TextView)listItemView.findViewById(R.id.author);
        trackAuthor.setText(currentSong.getmSongAuthor());

        TextView trackTime = (TextView)listItemView.findViewById(R.id.track_time);
        trackTime.setText(currentSong.getmSongTime());

        ImageView trackImage = (ImageView)listItemView.findViewById(R.id.track_image);
        trackImage.setImageResource(currentSong.getmSongImage());

        ImageView trackPlayButton = (ImageView)listItemView.findViewById(R.id.play_button);

        if (currentSong.isPlay()) {
            trackPlayButton.setImageResource(R.drawable.ic_pause);
        } else {
            trackPlayButton.setImageResource(R.drawable.ic_play_arrow);
        }


        return listItemView;
    }
}
