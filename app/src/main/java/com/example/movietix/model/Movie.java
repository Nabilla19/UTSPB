package com.example.movietix.model;

public class Movie {
    private String title;
    private String genre;
    private String posterUrl;

    public Movie(String title, String genre, String posterUrl) {
        this.title = title;
        this.genre = genre;
        this.posterUrl = posterUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getPosterUrl() {
        return posterUrl;
    }
}
