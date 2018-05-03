package com.twu.biblioteca.core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午8:26 2018/5/2
 */
public class MovieListTest {
    private MovieList movieList;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));

        Movie movie1 = new Movie("Name1",2001,"Director1","1");
        Movie movie2 = new Movie("Name2",2002,"Director2","2");
        Movie movie3 = new Movie("Name3",2003,"Director3");
        List<Movie> list = new ArrayList<>();
        list.add(movie1);
        list.add(movie2);
        list.add(movie3);

        Movie movie4 = new Movie("Name4",2004,"Director4");
        List<Movie> rentedMovies = new ArrayList<>();
        rentedMovies.add(movie4);
        movieList = new MovieList(list,rentedMovies);
    }

    @Test
    public void testShowMovieList() {
        movieList.showMovies();
        assertEquals(systemOut(),"Name1  Director1  2001  1\n" +
                "Name2  Director2  2002  2\n" +
                "Name3  Director3  2003  unrated\n");
    }

    @Test
    public void testCheckOutMovieSuccess() {
        Movie movie = movieList.checkOutMovie("Name1");
        String success = "Thank you! Enjoy the Movie\n";
        assertEquals(systemOut(), success);
        assertEquals(movie.getName(),"Name1");
    }

    @Test
    public void testCheckOutMovieFail() {
        Movie movie = movieList.checkOutMovie("Name5");
        String fail = "That Movie is not available.\n";
        assertEquals(systemOut(), fail);
        assertNull(movie);
    }

    @Test
    public void testReturnMovieSuccess() {
        Movie movie = movieList.returnMovie("Name4");
        String success = "Thank you for returning the movie.\n";
        assertEquals(systemOut(), success);
        assertEquals(movie.getName(),"Name4");
    }

    @Test
    public void testReturnMovieFail() {
        Movie movie = movieList.returnMovie("Name5");
        String fail = "That is not a valid movie to return.\n";
        assertEquals(systemOut(), fail);
        assertNull(movie);
    }

    private String systemOut() {
        return outContent.toString();
    }
}
