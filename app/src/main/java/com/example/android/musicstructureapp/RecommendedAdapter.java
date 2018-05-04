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

public class RecommendedAdapter extends ArrayAdapter<Song> {

    public RecommendedAdapter(Activity context, ArrayList<Song> recommended){
        super(context,0, recommended);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_recommended,
                    parent, false);
        }

        Song currentSong = getItem(position);


        TextView trackTitle = (TextView) listItemView.findViewById(R.id.recommended_track);
        trackTitle.setText(currentSong.getmSongName());

        TextView trackAuthor = (TextView) listItemView.findViewById(R.id.recommended_author);
        trackAuthor.setText(currentSong.getmSongAuthor());

        TextView trackTime = (TextView) listItemView.findViewById(R.id.recommended_track_time);
        trackTime.setText(currentSong.getmSongTime());

        ImageView trackImage = (ImageView) listItemView.findViewById(R.id.recommended_track_image);
        trackImage.setImageResource(currentSong.getmSongImage());

        return listItemView;
    }
}
