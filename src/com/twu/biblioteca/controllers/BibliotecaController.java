package com.twu.biblioteca.controllers;

import com.twu.biblioteca.core.*;
import com.twu.biblioteca.views.BibliotecaView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午3:28 2018/4/26
 */
public class BibliotecaController {
    private BibliotecaView bibliotecaView = new BibliotecaView();
    private BookList bookList;
    private UserList userList;
    private MovieList movieList;
    private BufferedReader bufferedReader;
    private String currentLibraryNumber;

    {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public BibliotecaController(BookList bookList, UserList userList, MovieList movieList) {
        this.bookList = bookList;
        this.userList = userList;
        this.movieList = movieList;
    }

    public BibliotecaController(BookList bookList, UserList userList) {
        this(bookList, userList,new MovieList(new ArrayList<>()));
    }

    public BibliotecaController() {
    }

    public BibliotecaController(BookList bookList) {
        this(bookList, new UserList(new ArrayList<>()),new MovieList(new ArrayList<>()));
    }

    public void begin() {
        bibliotecaView.welcome();
        bibliotecaView.showMainMenu();
    }


    public boolean validate(String input) {
        return needQuit(input) || needEnterBookList(input) || needReturnBook(input)
                || needEnterMovieList(input) || needReturnMovie(input) || needShowUserInfo(input);
    }

    public boolean needQuit(String input) {
        return "0".equals(input);
    }

    public boolean needEnterBookList(String input) {
        return "1".equals(input);
    }

    public boolean needReturnBook(String input) {
        return "2".equals(input);
    }


    public void start() throws IOException {
        //begin
        begin();

        String input = bufferedReader.readLine();
        if (needQuit(input))
            return;

        enterBookList(input);

        returnBook(input);

        enterMovieList(input);

        returnMovie(input);

        showUserInfo(input);

        showInvalidMenuOptionMessage(input);

        start();
    }

    private void showUserInfo(String input) {
        if (needShowUserInfo(input))
            userList.getUserByLibraryNumber(currentLibraryNumber).showInfo();
    }

    private void showInvalidMenuOptionMessage(String input) {
        if (!validate(input))
            bibliotecaView.invalidMenuOptionMessage();
    }

    private void returnBook(String input) throws IOException {
        if (needReturnBook(input)) {
            Book book = bookList.returnBook(bufferedReader.readLine());
            if (book != null)
                userList.getUserByLibraryNumber(currentLibraryNumber).removeBook(book);
        }
    }

    private void enterBookList(String input) throws IOException {
        if (needEnterBookList(input)) {
            bookList.showBookList();
            Book book = bookList.checkOutBook(bufferedReader.readLine());
            if (book != null)
                userList.getUserByLibraryNumber(currentLibraryNumber).addBook(book);
        }
    }

    private void enterMovieList(String input) throws IOException {
        if (needEnterMovieList(input)) {
            movieList.showMovies();
            Movie movie = movieList.checkOutMovie(bufferedReader.readLine());
            if (movie != null)
                userList.getUserByLibraryNumber(currentLibraryNumber).addMovie(movie);
        }
    }

    private void returnMovie(String input) throws IOException {
        if (needReturnMovie(input)) {
            Movie movie = movieList.returnMovie(bufferedReader.readLine());
            if (movie != null)
                userList.getUserByLibraryNumber(currentLibraryNumber).removeMovie(movie);
        }
    }

    public boolean needEnterMovieList(String input) {
        return "3".equals(input);
    }

    public boolean needReturnMovie(String input) {
        return "4".equals(input);
    }

    public boolean needShowUserInfo(String input) {
        return "5".equals(input);
    }

    public void login() throws IOException {
        bibliotecaView.showLoginMessage();
        String libraryNumber = bufferedReader.readLine();
        String password = bufferedReader.readLine();
        String result = userList.login(libraryNumber, password);
        System.out.println(result);
        if (!result.equals(LoginStatus.SUCCESS)) {
            login();
        } else {
            currentLibraryNumber = libraryNumber;
        }
    }

}
