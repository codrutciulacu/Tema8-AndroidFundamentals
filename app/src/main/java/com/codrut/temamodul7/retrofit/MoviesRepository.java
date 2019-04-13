package com.codrut.temamodul7.retrofit;

import android.support.annotation.NonNull;

import com.codrut.temamodul7.BuildConfig;
import com.codrut.temamodul7.interfaces.OnGetGenresCallback;
import com.codrut.temamodul7.interfaces.OnGetMoviesCallback;
import com.codrut.temamodul7.interfaces.MovieApi;
import com.codrut.temamodul7.interfaces.DatabaseApiKey;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesRepository {

    private static MoviesRepository sRepository;

    private MovieApi mMovieApi;

    public MoviesRepository(MovieApi api) {
        this.mMovieApi = api;
    }

    public static MoviesRepository getInstance() {
        if (sRepository == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(BuildConfig.BASE_MOVIES_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            sRepository = new MoviesRepository(retrofit.create(MovieApi.class));
        }

        return sRepository;
    }

    public void getTopRatedMovies(final OnGetMoviesCallback callback) {
        mMovieApi.getTopRatedMovies(DatabaseApiKey.API_KEY, "vote_count.desc", 1).enqueue(new Callback<MoviesPOJO>() {
            @Override
            public void onResponse(@NonNull Call<MoviesPOJO> call,
                                   @NonNull Response<MoviesPOJO> response) {
                if (response.isSuccessful()) {
                    MoviesPOJO moviesPOJO = response.body();
                    if (moviesPOJO != null && moviesPOJO.getMovies() != null) {
                        callback.onSuccess(moviesPOJO.getMovies());
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<MoviesPOJO> call, Throwable t) {
                callback.onError();
            }
        });
    }

    public void getUpcomingMovies(final OnGetMoviesCallback callback) {
        mMovieApi.getUpcomingMovies(DatabaseApiKey.API_KEY,1).enqueue(new Callback<MoviesPOJO>() {
            @Override
            public void onResponse(@NonNull Call<MoviesPOJO> call,
                                   @NonNull Response<MoviesPOJO> response) {
                if (response.isSuccessful()) {
                    MoviesPOJO moviesPOJO = response.body();
                    if (moviesPOJO != null && moviesPOJO.getMovies() != null) {
                        callback.onSuccess(moviesPOJO.getMovies());
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<MoviesPOJO> call, Throwable t) {
                callback.onError();
            }
        });
    }

    public void getNowPlayingMovies(final OnGetMoviesCallback callback) {
        mMovieApi.getNowMovies(DatabaseApiKey.API_KEY,"2019-03-15","2019-03-26",1).enqueue(new Callback<MoviesPOJO>() {
            @Override
            public void onResponse(@NonNull Call<MoviesPOJO> call,
                                   @NonNull Response<MoviesPOJO> response) {
                if (response.isSuccessful()) {
                   MoviesPOJO moviesPOJO = response.body();
                    if (moviesPOJO != null && moviesPOJO.getMovies() != null) {
                        callback.onSuccess(moviesPOJO.getMovies());
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<MoviesPOJO> call, Throwable t) {
                callback.onError();
            }
        });
    }

    public void getAllGenres(final OnGetGenresCallback callback) {

        mMovieApi.getAllGenres(DatabaseApiKey.API_KEY).enqueue(new Callback<GenresPOJO>() {
            @Override
            public void onResponse(Call<GenresPOJO> call, Response<GenresPOJO> response) {
                if (response.isSuccessful()) {
                    GenresPOJO genresPOJO = response.body();
                    if (genresPOJO != null && genresPOJO.getGenres() != null) {
                        callback.onSuccess(genresPOJO.getGenres());
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<GenresPOJO> call, Throwable t) {
                callback.onError();
            }
        });
    }
}
