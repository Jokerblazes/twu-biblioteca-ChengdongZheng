package com.twu.biblioteca.controllers;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        controller = new BibliotecaController();
    }

    @Test
    public void testBegin() {
        String result = "Welcome Biblioteca!\n1:List Books\n0:Quit\n";
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
        assertTrue(controller.returnBook("2"));
        assertFalse(controller.returnBook("0"));
    }


    private String systemOut() {
        return outContent.toString();
    }
}
