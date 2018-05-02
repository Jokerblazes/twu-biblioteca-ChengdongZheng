package com.twu.biblioteca.core;

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


    @Test
    public void validateAccount() {
        assertTrue(User.validate("xxx-xxxx"));
        assertFalse(User.validate("xxx-xxx"));
        assertFalse(User.validate("xxx1xxx"));
    }

}
