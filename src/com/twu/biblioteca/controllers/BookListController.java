package com.twu.biblioteca.controllers;

import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.views.BookListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午4:00 2018/4/26
 */
public class BookListController {
    private BookListView bookListView = new BookListView();
    private List<Book> books;
    private List<Book> rentedBooks;

    public BookListController(List<Book> books) {
        this.books = books;
        rentedBooks = new ArrayList<>();
    }

    public void showBookList() {
        bookListView.showHead();
        bookListView.showBookList(books);
    }

    public void checkOutBook(String name) {
        int index = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {
                rentedBooks.add(books.get(i));
                index = i;
                bookListView.showCheckOutSuccess();
                break;
            }
        }
        if (index == -1)
            bookListView.showCheckOutFail();
        else
            books.remove(index);
    }
}
