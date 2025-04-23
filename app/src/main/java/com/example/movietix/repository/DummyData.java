package com.example.movietix.repository;

import com.example.movietix.model.Ticket;
import com.example.movietix.model.Theater;

import java.util.ArrayList;
import java.util.List;

public class DummyData {

    public static List<Ticket> getDummyTickets() {
        List<Ticket> tickets = new ArrayList<>();

        tickets.add(new Ticket("Inception", "CGV Central Park", "21 April 2025", "A12"));
        tickets.add(new Ticket("Interstellar", "XXI Gandaria City", "22 April 2025", "B10"));
        tickets.add(new Ticket("Oppenheimer", "CGV AEON Mall", "23 April 2025", "C7"));

        return tickets;
    }

    public static List<Theater> getDummyTheaters() {
        List<Theater> theaters = new ArrayList<>();

        theaters.add(new Theater("CGV Central Park", "Jakarta Barat", new String[]{"3D", "Dolby Atmos"}));
        theaters.add(new Theater("XXI Gandaria City", "Jakarta Selatan", new String[]{"2D", "Premiere"}));
        theaters.add(new Theater("CGV AEON Mall", "Tangerang", new String[]{"4DX", "3D"}));

        return theaters;
    }
}
