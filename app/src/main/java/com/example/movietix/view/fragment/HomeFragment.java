package com.example.movietix.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movietix.R;
import com.example.movietix.view.adapter.MovieAdapter;
import com.example.movietix.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView rvNowPlaying, rvComingSoon;
    private MovieAdapter nowPlayingAdapter, comingSoonAdapter;
    private List<Movie> nowPlayingList = new ArrayList<>();
    private List<Movie> comingSoonList = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvNowPlaying = view.findViewById(R.id.rv_now_playing);
        rvComingSoon = view.findViewById(R.id.rv_coming_soon);

        // Setup layout horizontal
        rvNowPlaying.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvComingSoon.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        // Dummy data
        nowPlayingList.add(new Movie("Dune 2", "Sci-fi", "https://i.ibb.co/fYKr8HV/dune.jpg"));
        nowPlayingList.add(new Movie("Godzilla x Kong", "Action", "https://i.ibb.co/XbXgbLm/godzillakong.jpg"));

        comingSoonList.add(new Movie("Deadpool 3", "Action", "https://i.ibb.co/LJvVZKf/deadpool.jpg"));
        comingSoonList.add(new Movie("Inside Out 2", "Animation", "https://i.ibb.co/Y7CbJq2/insideout.jpg"));

        // Adapter
        nowPlayingAdapter = new MovieAdapter(getContext(), nowPlayingList);
        comingSoonAdapter = new MovieAdapter(getContext(), comingSoonList);

        rvNowPlaying.setAdapter(nowPlayingAdapter);
        rvComingSoon.setAdapter(comingSoonAdapter);

        return view;
    }
}
