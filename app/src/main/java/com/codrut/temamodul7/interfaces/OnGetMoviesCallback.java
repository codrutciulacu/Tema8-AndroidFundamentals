package com.codrut.temamodul7.interfaces;


import com.codrut.temamodul7.recyclerview.models.Movie;

import java.util.List;

public interface OnGetMoviesCallback {
    void onSuccess(List<Movie> movies);
    void onError();
}
