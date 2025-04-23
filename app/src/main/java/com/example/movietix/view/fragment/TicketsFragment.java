package com.example.movietix.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movietix.R;
import com.example.movietix.view.adapter.TicketAdapter;
import com.example.movietix.repository.DummyData;

public class TicketsFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tickets, container, false);

        recyclerView = root.findViewById(R.id.recycler_tickets);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new TicketAdapter(DummyData.getDummyTickets()));

        return root;
    }
}
