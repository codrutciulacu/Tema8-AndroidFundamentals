package com.codrut.temamodul7.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codrut.temamodul7.R;
import com.codrut.temamodul7.interfaces.OnGetMoviesCallback;
import com.codrut.temamodul7.recyclerview.models.Movie;
import com.codrut.temamodul7.recyclerview.MoviesListAdapter;
import com.codrut.temamodul7.retrofit.MoviesRepository;

import java.util.ArrayList;
import java.util.List;


public class TopRatedFragment extends Fragment {

    private MoviesRepository mMoviesRepository;
    private RecyclerView mRecyclerViewMovies;
    private MoviesListAdapter mAdapter;
    private FragmentActivity fragmentActivity;
    private List<Movie> mMovieList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_top_rated, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        fragmentActivity = getActivity();
        mMoviesRepository = MoviesRepository.getInstance();
        mRecyclerViewMovies = view.findViewById(R.id.recyclerview_movies);
        mRecyclerViewMovies.setLayoutManager(new LinearLayoutManager(fragmentActivity));
        mMovieList = new ArrayList<>();
        mAdapter = new MoviesListAdapter(mMovieList,fragmentActivity);
        mRecyclerViewMovies.setAdapter(mAdapter);
        mMoviesRepository.getTopRatedMovies(new OnGetMoviesCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                mAdapter = new MoviesListAdapter(movies,fragmentActivity);
                mRecyclerViewMovies.setAdapter(mAdapter);
            }

            @Override
            public void onError() {
                Toast.makeText(fragmentActivity, "Check internet connection", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
