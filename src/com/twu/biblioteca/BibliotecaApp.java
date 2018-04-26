package com.twu.biblioteca;

import com.twu.biblioteca.controllers.BibliotecaController;
import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.core.BookList;

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
        BibliotecaController controller = new BibliotecaController(new BookList(books,rentedBooks));

        try {
            controller.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
