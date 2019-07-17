package com.sergeyyaniuk.themoviedb.ui.movieList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sergeyyaniuk.themoviedb.R;
import com.sergeyyaniuk.themoviedb.data.model.Movie;
import com.sergeyyaniuk.themoviedb.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class PopularMoviesAdapter extends RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder>{

    public interface PopularMoviesAdapterListener {
        void onPopularClick(String movieId);
    }

    PopularMoviesAdapterListener listener;

    public PopularMoviesAdapter(PopularMoviesAdapterListener listener) {
        this.listener = listener;
    }

    List<Movie> movies = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from((parent.getContext()))
                .inflate(R.layout.list_item_favorites, parent, false);
        return new PopularMoviesAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (!movies.isEmpty()){
            holder.title.setText(movies.get(position).getTitle());
            holder.rating.setText(String.valueOf(movies.get(position).getVoteAverage()));
            holder.description.setText(movies.get(position).getOverview());
            String imageUrl = Constants.BASE_URL_IMAGE + movies.get(position).getPosterPath();
            Glide.with(holder.itemView.getContext()).load(imageUrl)
                    .apply(RequestOptions.centerCropTransform()).into(holder.coverImage);
        }
    }

    public void updateList(List<Movie> movies){
        this.movies = movies;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public Movie getItem(int position){
        return movies.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView coverImage;
        TextView title;
        TextView rating;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coverImage = itemView.findViewById(R.id.cover_iv);
            title = itemView.findViewById(R.id.title_tv);
            rating = itemView.findViewById(R.id.star_rating_tv);
            description = itemView.findViewById(R.id.description_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String movieId = String.valueOf(getItem(getAdapterPosition()).getId());
                    listener.onPopularClick(movieId);
                }
            });
        }
    }
}
