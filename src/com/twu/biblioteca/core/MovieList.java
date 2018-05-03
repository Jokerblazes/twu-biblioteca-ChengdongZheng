package com.twu.biblioteca.core;

import com.twu.biblioteca.views.MovieListView;

import java.util.ArrayList;
import java.util.List; /**
 * @Author Joker
 * @Description
 * @Date Create in 下午9:38 2018/5/2
 */
public class MovieList extends BorrowObject<Movie> {

    public MovieList(List<Movie> things) {
        super(things,new ArrayList<>(),new MovieListView());
    }

    public MovieList(List<Movie> things, List<Movie> rentedThings) {
        super(things, rentedThings,new MovieListView());
    }

//    private List<Movie> movies;
//    private List<Movie> rentedMovies;
//    private MovieListView view = new MovieListView();
//
//    public MovieList(List<Movie> movies) {
//        this(movies, new ArrayList<>());
//    }
//
//    public MovieList(List<Movie> movies, List<Movie> rentedMovies) {
//        this.movies = movies;
//        this.rentedMovies = rentedMovies;
//    }

//    public void showMovies() {
//        view.showMovies(movies);
//    }
//
//    public Movie checkOutMovie(String name) {
//        int index = searchMovie(name,movies);
//        return checkOutMovie(index);
//    }
//
//    private Movie checkOutMovie(int index) {
//        Movie movie = null;
//        if (index == -1) {
//            view.showCheckOutFail();
//        } else {
//            movie = movies.get(index);
//            rentedMovies.add(movie);
//            movies.remove(index);
//            view.showCheckOutSuccess();
//        }
//        return movie;
//    }
//
//    private int searchMovie(String name,List<Movie> target) {
//        for (int i = 0; i < target.size(); i++) {
//            if (target.get(i).getName().equals(name)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public Movie returnMovie(String name) {
//        int index = searchMovie(name,rentedMovies);
//
//        return returnMovie(index);
//
//    }
//
//    private Movie returnMovie(int index) {
//        Movie movie = null;
//        if (index == -1) {
//            view.showReturnFail();
//        } else {
//            movie = rentedMovies.get(index);
//            movies.add(movie);
//            rentedMovies.remove(index);
//            view.showReturnSuccess();
//        }
//        return movie;
//    }


    @Override
    protected boolean compare(Movie thing, String name) {
        return thing.getName().equals(name);
    }
}
