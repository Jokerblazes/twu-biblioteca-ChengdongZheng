package com.twu.biblioteca.core;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午9:38 2018/5/2
 */
public class Movie {
    private final String name;
    private final int year;
    private final String director;
    private final String rating;

    public Movie(String name, int year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public Movie(String name, int year, String director) {
        this(name, year, director, "unrated");
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }
}
