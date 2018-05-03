package com.twu.biblioteca.core;

import java.util.List; /**
 * @Author Joker
 * @Description
 * @Date Create in 上午10:41 2018/5/3
 */
public class UserList {
    private List<User> users;

    public UserList(List<User> users) {
        this.users = users;
    }


    public String login(String libraryNumber, String password) {
        if (!User.validate(libraryNumber))
            return LoginStatus.ACCOUNT_ERROR;
        for (User user :
                users) {
            if (user.getLibraryNumber().equals(libraryNumber) && user.getPassword().equals(password))
                return LoginStatus.SUCCESS;
            if (user.getLibraryNumber().equals(libraryNumber) && !user.getPassword().equals(password))
                return LoginStatus.PASSWORD_ERROR;
        }
        return LoginStatus.NOT_FOUND;
    }


}
