package com.twu.biblioteca.controllers;

import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.views.BookListView;

import java.util.List;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午4:00 2018/4/26
 */
public class BookListController {
    private BookListView bookListView = new BookListView();
    private List<Book> books;

    public BookListController(List<Book> books) {
        this.books = books;
    }

    public void showBookList() {
        bookListView.showHead();
        bookListView.showBookList(books);
    }
}
