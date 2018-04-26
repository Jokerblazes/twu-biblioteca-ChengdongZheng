package com.twu.biblioteca.core;

import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.views.BookListView;

import java.util.List;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午4:00 2018/4/26
 */
public class BookList {
    private BookListView bookListView = new BookListView();
    private List<Book> books;
    private List<Book> rentedBooks;

    public BookList(List<Book> books,List<Book> rentedBooks) {
        this.books = books;
        this.rentedBooks = rentedBooks;
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

    public void returnBook(String name) {
        int index = -1;
        for (int i = 0; i < rentedBooks.size(); i++) {
            if (rentedBooks.get(i).getName().equals(name)) {
                books.add(rentedBooks.get(i));
                index = i;
                bookListView.showReturnSuccess();
                break;
            }
        }
        if (index == -1)
            bookListView.showReturnFail();
        else
            rentedBooks.remove(index);
    }
}
