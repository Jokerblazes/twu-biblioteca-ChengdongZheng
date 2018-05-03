package com.twu.biblioteca.views;

import com.twu.biblioteca.core.Movie;

import java.util.List; /**
 * @Author Joker
 * @Description
 * @Date Create in 下午9:51 2018/5/2
 */
public class MovieListView extends BorrowListView<Movie> {

    public MovieListView() {
        super("movie");
    }

    @Override
    public void showHead() {
        System.out.println("Name  Director  Year  Rate");
    }

    @Override
    public void showThings(List<Movie> movies) {
        movies.forEach(movie -> System.out.println(movie.getName() + "  " + movie.getDirector()
                + "  " + movie.getYear() + "  " + movie.getRating()));
    }
}
