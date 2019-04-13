package com.codrut.temamodul7.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codrut.temamodul7.R;
import com.codrut.temamodul7.TabbedActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.codrut.temamodul7.recyclerview.models.Genre;
import com.codrut.temamodul7.recyclerview.models.Movie;

import java.text.DecimalFormat;
import java.util.List;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListViewHolder> {

    private List<Movie> mMovieList;
    private Context mContext;


    public MoviesListAdapter(List<Movie> movies, Context context) {
        this.mMovieList = movies;
        mContext = context;
    }

    @NonNull
    @Override
    public MoviesListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie,
                viewGroup, false);
        return new MoviesListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesListViewHolder moviesListViewHolder, int i) {

        Movie currentMovie = mMovieList.get(i);
        moviesListViewHolder.getTextViewTitle().setText(currentMovie.getTitle());
        moviesListViewHolder.getRatingBar().setRating(currentMovie.getVoteAverage());
        DecimalFormat df2 = new DecimalFormat("#,###,###,##0");
        moviesListViewHolder.getTextViewVoteCount().setText("Votes: " + String.valueOf(df2.format(currentMovie.getVoteCount())));

        StringBuilder stringBuilder = new StringBuilder("Genres: ");
        int[] list = currentMovie.getGenreIds();

        for (int j = 0; j < list.length; j++) {

            for (Genre k : TabbedActivity.getGenresList()) {
                if (list[j] == k.getId()) {
                    stringBuilder.append(k.getName());
                }
            }

            if (j != list.length - 1) {
                stringBuilder.append(", ");
            }

        }

        moviesListViewHolder.getTextViewGenres().setText(stringBuilder);

        moviesListViewHolder.getTextViewReleaseDate().setText("Release date: " + currentMovie.getReleaseDate());

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.no_picture)
                .error(R.drawable.no_picture)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .dontAnimate()
                .dontTransform();

        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/w342" + currentMovie.getPosterPath())
                .apply(options)
                .into(moviesListViewHolder.getImageView());


    }


    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

}