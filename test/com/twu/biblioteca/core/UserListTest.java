package com.twu.biblioteca.core;


import com.twu.biblioteca.exception.LibraryNumberException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Joker
 * @Description
 * @Date Create in 上午10:39 2018/5/3
 */
public class UserListTest {
    private UserList userList;

    @Before
    public void setUp() throws LibraryNumberException {
        User user1 = User.createUser("123-4567", "123456");
        User user2 = User.createUser("123-4568", "123456");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        userList = new UserList(users);
    }

    @Test
    public void testLogin() {
        String success = userList.login("123-4567", "123456");
        String notFound = userList.login("123-4569", "123456");
        String passwordError = userList.login("123-4567", "123457");
        String accountError = userList.login("1231123", "123456");
        assertEquals(success, LoginStatus.SUCCESS);
        assertEquals(notFound, LoginStatus.NOT_FOUND);
        assertEquals(passwordError, LoginStatus.PASSWORD_ERROR);
        assertEquals(accountError, LoginStatus.ACCOUNT_ERROR);
    }



}
