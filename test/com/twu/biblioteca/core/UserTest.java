package com.twu.biblioteca.core;

import com.twu.biblioteca.exception.LibraryNumberException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午4:46 2018/5/2
 */
public class UserTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();


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


    private String systemOut() {
        return outContent.toString();
    }
}
