package com.example.movietix.repository;

import com.example.movietix.model.Ticket;
import com.example.movietix.model.Theater;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class DummyDataUploader {

    public static void uploadDummyData() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference rootRef = database.getReference();

        // Upload tickets
        List<Ticket> tickets = DummyData.getDummyTickets();
        for (int i = 0; i < tickets.size(); i++) {
            rootRef.child("tickets").child("ticket_" + i).setValue(tickets.get(i));
        }

        // Upload theaters
        List<Theater> theaters = DummyData.getDummyTheaters();
        for (int i = 0; i < theaters.size(); i++) {
            rootRef.child("theaters").child("theater_" + i).setValue(theaters.get(i));
        }
    }
}
