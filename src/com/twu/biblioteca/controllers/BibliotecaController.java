package com.twu.biblioteca.controllers;

import com.twu.biblioteca.views.BibliotecaView;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午3:28 2018/4/26
 */
public class BibliotecaController {
    private BibliotecaView bibliotecaView = new BibliotecaView();

    public void begin() {
        bibliotecaView.welcome();
        bibliotecaView.showMainMenu();
    }


    public boolean validate(String input) {
        return "1".equals(input) || "0".equals(input);
    }
}
