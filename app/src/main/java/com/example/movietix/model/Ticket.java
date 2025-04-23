package com.example.movietix.model;

public class Ticket {
    private String movieTitle;
    private String theaterName;
    private String date;
    private String seat;

    public Ticket(String movieTitle, String theaterName, String date, String seat) {
        this.movieTitle = movieTitle;
        this.theaterName = theaterName;
        this.date = date;
        this.seat = seat;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public String getDate() {
        return date;
    }

    public String getSeat() {
        return seat;
    }
}
