package com.twu.biblioteca.core;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午4:01 2018/4/26
 */
public class BookListTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private BookList controller;
    private List<Book> books;
    private List<Book> rentedBooks;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        //book list
        books = new ArrayList<>();
        books.add(new Book("Book1","Jack",2000));
        books.add(new Book("Book2","Jim",1990));
        books.add(new Book("Book3","Tom",1991));

        //rented book list
        rentedBooks = new ArrayList<>();
        rentedBooks.add(new Book("Book9","Jack1",2000));
        controller = new BookList(books,rentedBooks);
    }

    @Test
    public void testShowBookList() {
        controller.showBookList();
        assertEquals(systemOut(),"Name  Author  Year\n" +
                "Book1  Jack  2000\n" +
                "Book2  Jim  1990\n" +
                "Book3  Tom  1991\n");
    }

    @Test
    public void testCheckOutBookSuccess() {
        controller.checkOutBook("Book1");
        String success = "Thank you! Enjoy the book\n";
        assertEquals(systemOut(), success);
    }

    @Test
    public void testCheckOutBookFail() {
        controller.checkOutBook("Book9");
        String fail = "That book is not available.\n";
        assertEquals(systemOut(), fail);
    }

    @Test
    public void testReturnBookSuccess() {
        controller.returnBook("Book9");
        String success = "Thank you for returning the book.\n";
        assertEquals(systemOut(),success);
    }

    @Test
    public void testReturnBookFail() {
        String fail = "That is not a valid book to return.\n";
        controller.returnBook("Book10");
        assertEquals(systemOut(), fail);
    }

    private String systemOut() {
        return outContent.toString();
    }
}