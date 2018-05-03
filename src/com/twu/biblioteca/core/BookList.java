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

    public Book checkOutBook(String name) {
        //1:search book from books
        int index = searchBook(name, books);

        //2:check out book
        return checkOutBook(index);
    }

    private Book checkOutBook(int index) {
        Book book = null;
        if (index == -1) {
            bookListView.showCheckOutFail();
        } else {
            book = books.get(index);
            rentedBooks.add(book);
            books.remove(index);
            bookListView.showCheckOutSuccess();
        }
        return book;
    }

    public void returnBook(String name) {
        //1:search book from rentedBooks
        int index = searchBook(name,rentedBooks);

        //2:return book
        returnBook(index);
    }

    private void returnBook(int index) {
        if (index == -1) {
            bookListView.showReturnFail();
        } else {
            books.add(rentedBooks.get(index));
            rentedBooks.remove(index);
            bookListView.showReturnSuccess();
        }
    }

    private int searchBook(String name,List<Book> target) {
        for (int i = 0; i < target.size(); i++) {
            if (target.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
