package com.twu.biblioteca.core;

import com.twu.biblioteca.views.MovieListView;

import java.util.List; /**
 * @Author Joker
 * @Description
 * @Date Create in 下午9:38 2018/5/2
 */
public class MovieList {

    private List<Movie> movies;
    private MovieListView view = new MovieListView();

    public MovieList(List<Movie> movies) {
        this.movies = movies;
    }


    public void showMovies() {
        view.showMovies(movies);
    }
}
