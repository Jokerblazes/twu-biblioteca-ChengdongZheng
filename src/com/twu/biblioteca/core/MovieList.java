package com.twu.biblioteca.core;

import com.twu.biblioteca.views.MovieListView;

import java.util.ArrayList;
import java.util.List; /**
 * @Author Joker
 * @Description
 * @Date Create in 下午9:38 2018/5/2
 */
public class MovieList {

    private List<Movie> movies;
    private List<Movie> rentedMovies;
    private MovieListView view = new MovieListView();

    public MovieList(List<Movie> movies) {
        this(movies, new ArrayList<>());
    }

    public MovieList(List<Movie> movies, List<Movie> rentedMovies) {
        this.movies = movies;
        this.rentedMovies = rentedMovies;
    }

    public void showMovies() {
        view.showMovies(movies);
    }

    public void checkOutMovie(String name) {
        int index = searchMovie(name,movies);
        checkOutMovie(index);
    }

    private void checkOutMovie(int index) {
        if (index == -1) {
            view.showCheckOutFail();
        } else {
            rentedMovies.add(movies.get(index));
            movies.remove(index);
            view.showCheckOutSuccess();
        }
    }

    private int searchMovie(String name,List<Movie> target) {
        for (int i = 0; i < target.size(); i++) {
            if (target.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
