package com.twu.biblioteca.core;

import com.twu.biblioteca.exception.LibraryNumberException;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午4:47 2018/5/2
 */
public class User {

    private final String libraryNumber;
    private final String password;
    private String phoneNumber;
    private String name;
    private String email;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public static boolean validate(String libraryNumber) {
        if (libraryNumber.length() != 8)
            return false;

        if (libraryNumber.charAt(3) != '-')
            return false;
        return true;
    }


    public static User createUser(String libraryNumber, String password) throws LibraryNumberException {
        if (!validate(libraryNumber))
            throw new LibraryNumberException();
        return new User(libraryNumber,password);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void showInfo() {
        System.out.println(name + "  " + email + "  " + phoneNumber);
    }
}
