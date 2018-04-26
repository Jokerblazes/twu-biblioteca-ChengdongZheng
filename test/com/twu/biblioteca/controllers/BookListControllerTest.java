package com.twu.biblioteca.controllers;

import com.twu.biblioteca.core.Book;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午4:01 2018/4/26
 */
public class BookListControllerTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private BookListController controller;
    private List<Book> books;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        books = Arrays.asList(new Book("Book1","Jack",2000),
                new Book("Book2","Jim",1990),
                new Book("Book3","Tom",1991));
        controller = new BookListController(books);
    }

    @Test
    public void testShowBookList() {
        controller.showBookList();
        assertEquals(systemOut(),"Name  Author  Year\n" +
                "Book1  Jack  2000\n" +
                "Book2  Jim  1990\n" +
                "Book3  Tom  1991\n");
    }

    private String systemOut() {
        return outContent.toString();
    }
}