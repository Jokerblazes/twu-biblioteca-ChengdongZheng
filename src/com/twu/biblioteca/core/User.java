package com.twu.biblioteca.core;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午4:47 2018/5/2
 */
public class User {

    public static boolean validate(String libraryNumber) {
        if (libraryNumber.length() != 8)
            return false;

        if (libraryNumber.charAt(3) != '-')
            return false;
        return true;
    }
}
