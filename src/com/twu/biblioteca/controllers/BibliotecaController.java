package com.twu.biblioteca.controllers;

import com.twu.biblioteca.core.BookList;
import com.twu.biblioteca.views.BibliotecaView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午3:28 2018/4/26
 */
public class BibliotecaController {
    private BibliotecaView bibliotecaView = new BibliotecaView();
    private BookList bookList;
    private BufferedReader bufferedReader;

    {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public BibliotecaController() {
    }

    public BibliotecaController(BookList bookList) {
        this.bookList = bookList;
    }

    public void begin() {
        bibliotecaView.welcome();
        bibliotecaView.showMainMenu();
    }


    public boolean validate(String input) {
        return needQuit(input) || needEnterBookList(input) || returnBook(input);
    }

    public boolean needQuit(String input) {
        return "0".equals(input);
    }

    public boolean needEnterBookList(String input) {
        return "1".equals(input);
    }

    public boolean returnBook(String input) {
        return "2".equals(input);
    }


}
