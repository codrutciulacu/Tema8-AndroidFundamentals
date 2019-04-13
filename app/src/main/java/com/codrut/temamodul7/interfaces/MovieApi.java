package com.codrut.temamodul7.interfaces;


import com.codrut.temamodul7.recyclerview.models.Movie;
import com.codrut.temamodul7.retrofit.GenresPOJO;
import com.codrut.temamodul7.retrofit.MoviesPOJO;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("discover/movie")
    Call<MoviesPOJO> getTopRatedMovies(
            @Query("api_key") String apiKey,
            @Query("sort_by") String shortBy,
            @Query("page") int page
    );

    @GET("genre/movie/list")
    Call<GenresPOJO> getAllGenres(
            @Query("api_key") String apiKey
    );



    @GET("movie/upcoming")
    Call<MoviesPOJO> getUpcomingMovies(
            @Query("api_key") String apiKey,
            @Query("page") int page
    );

    @GET("discover/movie")
    Call<MoviesPOJO> getNowMovies(
            @Query("api_key") String apiKey,
            @Query("primary_release_date.gte") String dateGte,
            @Query("primary_release_date.lte") String dateLte,
            @Query("page") int page
    );

    @GET("/discover/movie?primary_release_date.gte=2019-03-15&primary_release_date.lte=2019-03-26&api_key="+ DatabaseApiKey.API_KEY)
    Call<List<Movie>> getNowMovies();


}
