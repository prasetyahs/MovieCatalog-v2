package com.syncode.submission2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.syncode.submission2.DetailActivity;
import com.syncode.submission2.Model.MoviesModel;
import com.syncode.submission2.R;

import java.util.List;

public class AdapterMovies extends RecyclerView.Adapter<AdapterMovies.ViewHolder> {

    private List<MoviesModel> listMovies;
    private Context context;

    public AdapterMovies(List<MoviesModel> listMovies, Context context) {
        this.listMovies = listMovies;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.movies_rows, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final MoviesModel moviesModel = listMovies.get(position);
        holder.imgMovie.setImageResource(moviesModel.getImg());
        holder.txtDesc.setText(moviesModel.getDescription());
        holder.txtDate.setText(moviesModel.getDate());
        holder.txtTitle.setText(moviesModel.getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoDetails = new Intent(context, DetailActivity.class);
                gotoDetails.putExtra("movies", moviesModel);
                context.startActivity(gotoDetails);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgMovie;
        TextView txtTitle;
        TextView txtDate;
        TextView txtDesc;
        CardView cardView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMovie = itemView.findViewById(R.id.img_movie);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtDate = itemView.findViewById(R.id.txt_date);
            txtDesc = itemView.findViewById(R.id.txt_desc);
            cardView = itemView.findViewById(R.id.card_view);
        }

    }
}
