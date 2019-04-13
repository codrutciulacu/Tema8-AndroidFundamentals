package com.codrut.temamodul7.retrofit;

import com.codrut.temamodul7.recyclerview.models.Genre;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GenresPOJO {

    @SerializedName("genres")
    private List<Genre> mGenres;

    public List<Genre> getGenres() {
        return mGenres;
    }

    public void setGenres(List<Genre> genres) {
        mGenres = genres;
    }
}
