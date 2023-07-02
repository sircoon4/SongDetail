package com.example.songdetail;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.songdetail.content.SongUtils;

public class SongDetailFragment extends Fragment {
    public SongUtils.Song mSong;

    public SongDetailFragment() {
        // Required empty public constructor
    }

    public static SongDetailFragment newInstance(int selectedSong) {
        Bundle args = new Bundle();
        args.putInt(SongUtils.SONG_ID_KEY, selectedSong);

        SongDetailFragment fragment = new SongDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments().containsKey(SongUtils.SONG_ID_KEY)){
            mSong = SongUtils.SONG_ITEMS.get(getArguments().getInt(SongUtils.SONG_ID_KEY));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.song_detail, container, false);

        if(mSong != null){
            ((TextView) rootView.findViewById(R.id.song_detail)).setText(mSong.details);
        }

        return rootView;
    }
}