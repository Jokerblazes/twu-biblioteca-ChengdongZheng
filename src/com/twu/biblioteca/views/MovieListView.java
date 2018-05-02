package com.twu.biblioteca.views;

import com.twu.biblioteca.core.Movie;

import java.util.List; /**
 * @Author Joker
 * @Description
 * @Date Create in 下午9:51 2018/5/2
 */
public class MovieListView {
    public void showMovies(List<Movie> movies) {
        movies.forEach(movie -> System.out.println(movie.getName() + "  " + movie.getDirector()
                + "  " + movie.getYear() + "  " + movie.getRating()));
    }

    public void showCheckOutFail() {
        System.out.println("That Movie is not available.");
    }

    public void showCheckOutSuccess() {
        System.out.println("Thank you! Enjoy the Movie");
    }
}
