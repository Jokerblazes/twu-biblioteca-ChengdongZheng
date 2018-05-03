package com.twu.biblioteca;

import com.twu.biblioteca.controllers.BibliotecaController;
import com.twu.biblioteca.core.*;
import com.twu.biblioteca.exception.LibraryNumberException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {

        //book list
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book1","Jack",2000));
        books.add(new Book("Book2","Jim",1990));
        books.add(new Book("Book3","Tom",1991));

        //rented book list
        List<Book> rentedBooks = new ArrayList<>();
        rentedBooks.add(new Book("Book9","Jack1",2000));



        //movie list
        Movie movie1 = new Movie("Name1",2001,"Director1","1");
        Movie movie2 = new Movie("Name2",2002,"Director2","2");
        Movie movie3 = new Movie("Name3",2003,"Director3");
        List<Movie> list = new ArrayList<>();
        list.add(movie1);
        list.add(movie2);
        list.add(movie3);

        //rented movie list
        Movie movie4 = new Movie("Name4",2004,"Director4");
        List<Movie> rentedMovies = new ArrayList<>();
        rentedMovies.add(movie4);
        MovieList movieList = new MovieList(list, rentedMovies);

        //user list
        User user1 = null;
        User user2 = null;
        try {
            user1 = User.createUser("123-4567", "123456");
            user2 = User.createUser("123-4568", "123456");
        } catch (LibraryNumberException e) {
            e.printStackTrace();
        }
        List<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        UserList userList = new UserList(users);

        BibliotecaController controller = new BibliotecaController(new BookList(books,rentedBooks),userList,movieList);
        try {
            controller.login();
            controller.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
