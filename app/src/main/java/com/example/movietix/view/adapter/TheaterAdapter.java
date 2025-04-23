package com.example.movietix.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.movietix.R;
import com.example.movietix.model.Theater;
import java.util.List;

public class TheaterAdapter extends RecyclerView.Adapter<TheaterAdapter.ViewHolder> {

    private List<Theater> theaters;

    public TheaterAdapter(List<Theater> theaters) {
        this.theaters = theaters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_theater, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Theater theater = theaters.get(position);
        holder.name.setText(theater.getName());
        holder.location.setText(theater.getLocation());

        // Gabungkan tag jadi satu string
        StringBuilder tagsString = new StringBuilder();
        for (String tag : theater.getTags()) {
            tagsString.append(tag).append("  ");
        }
        holder.tags.setText(tagsString.toString().trim());
    }

    @Override
    public int getItemCount() {
        return theaters.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, location, tags;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.theater_name);
            location = itemView.findViewById(R.id.theater_location);
            tags = itemView.findViewById(R.id.theater_tags);
        }
    }
}
