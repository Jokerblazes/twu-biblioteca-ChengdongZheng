package com.twu.biblioteca.views;

import java.util.List; /**
 * @Author Joker
 * @Description
 * @Date Create in 下午3:10 2018/5/3
 */
public abstract class BorrowListView<T> {
    protected String object;

    public BorrowListView(String object) {
        this.object = object;
    }
    public void showCheckOutFail() {
        System.out.println("That " + object + " is not available.");
    }

    public void showCheckOutSuccess() {
        System.out.println("Thank you! Enjoy the " + object);
    }

    public void showReturnSuccess() {
        System.out.println("Thank you for returning the " + object + ".");
    }

    public void showReturnFail() {
        System.out.println("That is not a valid " + object + " to return.");
    }


    public abstract void showHead();

    public abstract void showThings(List<T> things);



}
