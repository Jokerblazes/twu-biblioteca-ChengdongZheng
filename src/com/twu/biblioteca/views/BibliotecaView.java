package com.twu.biblioteca.views;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午3:30 2018/4/26
 */
public class BibliotecaView {

    public void welcome() {
        System.out.println("Welcome Biblioteca!");
    }

    public void showMainMenu() {
        System.out.println("1:List Books\n2:Return Book\n" +
                "3:List Movies\n4:Return Movie\n5:User Info\n0:Quit");
    }

    public void invalidMenuOptionMessage() {
        System.out.println("Select a valid option!");
    }

    public void showLoginMessage() {
        System.out.println("Please input library number and password.");
    }
}
