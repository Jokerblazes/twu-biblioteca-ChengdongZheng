package com.twu.biblioteca.controllers;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.core.BookList;
import com.twu.biblioteca.core.User;
import com.twu.biblioteca.core.UserList;
import com.twu.biblioteca.exception.LibraryNumberException;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午3:27 2018/4/26
 */
public class BibliotecaControllerTest {
    private BibliotecaController controller;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws LibraryNumberException {
        System.setOut(new PrintStream(outContent));

        //book lists
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book1","Jack",2000));
        books.add(new Book("Book2","Jim",1990));
        books.add(new Book("Book3","Tom",1991));

        //rented book list
        List<Book> rentedBooks = new ArrayList<>();
        rentedBooks.add(new Book("Book9","Jack1",2000));

        //movie lists
        User user1 = User.createUser("123-4567", "123456");
        User user2 = User.createUser("123-4568", "123456");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        UserList userList = new UserList(users);
        controller = new BibliotecaController(new BookList(books,rentedBooks),userList);

    }

    @Test
    public void testBegin() {
        String result = "Welcome Biblioteca!\n1:List Books\n2:Return Book\n" +
                "3:List Movies\n4:Return Movie\n5:User Info\n0:Quit\n";
        controller.begin();
        assertEquals(systemOut(), result);
    }

    @Test
    public void testValidateNumber() {
        assertTrue(controller.validate("1"));
        assertTrue(controller.validate("0"));
        assertFalse(controller.validate("s"));
    }

    @Test
    public void testNeedQuit() {
        assertTrue(controller.needQuit("0"));
        assertFalse(controller.needQuit("1"));
    }

    @Test
    public void testNeedEnterBookList() {
        assertTrue(controller.needEnterBookList("1"));
        assertFalse(controller.needEnterBookList("0"));
    }

    @Test
    public void testIsReturnBook() {
        assertTrue(controller.needReturnBook("2"));
        assertFalse(controller.needReturnBook("0"));
    }

    @Test
    public void testNeedEnterMovieList() {
        assertTrue(controller.needEnterMovieList("3"));
        assertFalse(controller.needEnterMovieList("0"));
    }

    @Test
    public void testIsReturnMovie() {
        assertTrue(controller.needReturnMovie("4"));
        assertFalse(controller.needReturnMovie("0"));
    }




    private String systemOut() {
        return outContent.toString();
    }
}
