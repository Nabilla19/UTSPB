package com.example.movietix.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movietix.R;
import com.example.movietix.model.Ticket;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.ViewHolder> {

    private List<Ticket> tickets;

    public TicketAdapter(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @NonNull
    @Override
    public TicketAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ticket, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketAdapter.ViewHolder holder, int position) {
        Ticket ticket = tickets.get(position);
        holder.movieTitle.setText(ticket.getMovieTitle());
        holder.theaterName.setText(ticket.getTheaterName());
        holder.date.setText(ticket.getDate());
        holder.seat.setText("Seat " + ticket.getSeat());
    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView movieTitle, theaterName, date, seat;

        public ViewHolder(View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.ticket_movie_title);
            theaterName = itemView.findViewById(R.id.ticket_theater_name);
            date = itemView.findViewById(R.id.ticket_date);
            seat = itemView.findViewById(R.id.ticket_seat);
        }
    }
}
