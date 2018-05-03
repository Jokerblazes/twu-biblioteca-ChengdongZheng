package com.twu.biblioteca.core;

import com.twu.biblioteca.exception.LibraryNumberException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午4:46 2018/5/2
 */
public class UserTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testValidateAccount() {
        assertTrue(User.validate("xxx-xxxx"));
        assertFalse(User.validate("xxx-xxx"));
        assertFalse(User.validate("xxx1xxx"));
    }

    @Test
    public void testCreateUser() {
        try {
            User user = User.createUser("xxx-xxxx","123456");
            assertTrue(true);
        } catch (LibraryNumberException e) {
            assertTrue(false);
        }

        try {
            User user = User.createUser("xxx1xxxx","123456");
            assertTrue(false);
        } catch (LibraryNumberException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testShowInfo() {
        // create a user
        User user = null;
        try {
             user = User.createUser("xxx-xxxx","123456");
            assertTrue(true);
        } catch (LibraryNumberException e) {
            assertTrue(false);
        }
        user.setEmail("1234566@outlook.com");
        user.setName("Tim");
        user.setPhoneNumber("12345678");

        //show user information
        user.showInfo();
        assertEquals(systemOut(),"Tim  1234566@outlook.com  12345678\n");
    }

    @Test
    public void testAddBook() {
        // create a user
        User user = null;
        try {
            user = User.createUser("xxx-xxxx","123456");
            assertTrue(true);
        } catch (LibraryNumberException e) {
            assertTrue(false);
        }
        Book book = new Book("Name1", "Jim", 1990);
        user.addBook(book);
        assertEquals(user.getBooks().size(),1);
        assertEquals(user.getBooks().get(0),book);
    }

    @Test
    public void testAddMovie() {
        // create a user
        User user = null;
        try {
            user = User.createUser("xxx-xxxx","123456");
            assertTrue(true);
        } catch (LibraryNumberException e) {
            assertTrue(false);
        }
        Movie movie = new Movie("Name1",1,"Tim");
        user.addMovie(movie);
        assertEquals(user.getMovies().size(),1);
        assertEquals(user.getMovies().get(0),movie);
    }


    private String systemOut() {
        return outContent.toString();
    }
}
