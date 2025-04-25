package com.example.movietix.repository;

import com.example.movietix.model.Ticket;
import com.example.movietix.model.Theater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DummyData {

    public static List<Ticket> getDummyTickets() {
        List<Ticket> tickets = new ArrayList<>();

        tickets.add(new Ticket("Godzilla x Kong: The New Empire", "CGV Mal SKA", "26 April 2025", "D5"));
        tickets.add(new Ticket("Wonka", "XXI Living World", "27 April 2025", "E7"));
        tickets.add(new Ticket("The Garfield Movie", "CGV Transmart Pekanbaru", "28 April 2025", "F3"));

        return tickets;
    }

    public static List<Theater> getDummyTheaters() {
        List<Theater> theaters = new ArrayList<>();

        theaters.add(new Theater("CGV Mal SKA", "Pekanbaru", Arrays.asList("3D", "Dolby Atmos")));
        theaters.add(new Theater("XXI Living World", "Pekanbaru", Arrays.asList("2D", "Premiere")));
        theaters.add(new Theater("CGV Transmart Pekanbaru", "Pekanbaru", Arrays.asList("4DX", "3D")));

        return theaters;
    }
}
