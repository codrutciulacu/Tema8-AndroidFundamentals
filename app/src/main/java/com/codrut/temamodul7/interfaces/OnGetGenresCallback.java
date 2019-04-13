package com.codrut.temamodul7.interfaces;

import com.codrut.temamodul7.recyclerview.models.Genre;

import java.util.List;

public interface OnGetGenresCallback {

    void onSuccess(List<Genre> genres);
    void onError();


}
