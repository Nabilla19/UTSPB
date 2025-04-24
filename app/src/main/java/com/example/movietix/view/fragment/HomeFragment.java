package com.example.movietix.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movietix.R;
import com.example.movietix.model.Movie;
import com.example.movietix.view.adapter.MovieAdapter;

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

        // Dummy data with unique images
        nowPlayingList.add(new Movie("Dune 2", "Sci-fi", "https://i.pinimg.com/474x/b7/95/44/b795447414c34b18eddc91fdea0fffef.jpg"));
        nowPlayingList.add(new Movie("Godzilla x Kong", "Action", "https://i.pinimg.com/474x/6f/77/43/6f77434d81ceeb6ea45c077bfb6a6242.jpg"));
        nowPlayingList.add(new Movie("Oppenheimer", "Biographical Drama", "https://i.pinimg.com/474x/77/9d/a3/779da30964fb69b47c4f03138d482f9d.jpg"));
        nowPlayingList.add(new Movie("Wonka", "Fantasy", "https://i.pinimg.com/474x/f3/c2/23/f3c22331a548958a463cc44f08cccd4f.jpg"));
        nowPlayingList.add(new Movie("Aquaman and the Lost Kingdom", "Action", "https://i.pinimg.com/474x/b8/1f/b1/b81fb171542b10350a6ef14b3fca3450.jpg"));
        nowPlayingList.add(new Movie("The Marvels", "Action", "https://i.pinimg.com/474x/be/28/cd/be28cdf5478b9a3bfd05253265cdd758.jpg"));
        nowPlayingList.add(new Movie("Napoleon", "Historical Drama", "https://i.pinimg.com/474x/f8/ec/3a/f8ec3a0141596be0ae3e083573e1b023.jpg"));
        nowPlayingList.add(new Movie("Mission: Impossible - Dead Reckoning Part One", "Action", "https://i.pinimg.com/474x/d9/50/a2/d950a23b43c165bc2d7a338b20c371f9.jpg"));

        comingSoonList.add(new Movie("Deadpool 3", "Action", "https://i.pinimg.com/474x/73/48/cb/7348cbb09eb99aae17bcfaccfd21c165.jpg"));
        comingSoonList.add(new Movie("Inside Out 2", "Animation", "https://i.pinimg.com/736x/a0/bf/eb/a0bfebcc8b0532bfe616e66b709a04be.jpg"));
        comingSoonList.add(new Movie("The Creator", "Sci-fi", "https://i.pinimg.com/736x/68/4c/1a/684c1a77b5d4baf4fdf29cae4c58a57c.jpg")); // ← Pakai gambar yang kamu upload (atau ganti URL sesuai upload kamu)
        comingSoonList.add(new Movie("Furiosa: A Mad Max Saga", "Action", "https://i.pinimg.com/474x/82/3f/c2/823fc28eabcf4d30e200d672032d3e8d.jpg"));
        comingSoonList.add(new Movie("Kingdom of the Planet of the Apes", "Sci-fi", "https://i.pinimg.com/474x/ae/3f/03/ae3f0324d81da0fd3ba84443dc6a93b3.jpg"));
        comingSoonList.add(new Movie("Garfield", "Animation", "https://i.pinimg.com/474x/0d/82/9e/0d829e3e3356b4483821f94f7efb904f.jpg"));
        comingSoonList.add(new Movie("IF", "Fantasy", "https://i.pinimg.com/474x/e0/da/a5/e0daa5b51996482026e1c04b2bb27189.jpg"));
        comingSoonList.add(new Movie("Bad Boys: Ride or Die", "Action", "https://i.pinimg.com/474x/13/c3/cb/13c3cbcf555de488a4f10dc1d1782614.jpg"));
        comingSoonList.add(new Movie("Despicable Me 4", "Animation", "https://i.pinimg.com/474x/e2/7a/3a/e27a3a29a76b55861036484971d35548.jpg"));
        // Set adapter
        nowPlayingAdapter = new MovieAdapter(getContext(), nowPlayingList);
        comingSoonAdapter = new MovieAdapter(getContext(), comingSoonList);

        rvNowPlaying.setAdapter(nowPlayingAdapter);
        rvComingSoon.setAdapter(comingSoonAdapter);

        return view;
    }
}
