package com.twu.biblioteca.views;

import com.twu.biblioteca.core.Book;

import java.util.List; /**
 * @Author Joker
 * @Description
 * @Date Create in 下午4:12 2018/4/26
 */
public class BookListView extends BorrowListView<Book> {

    public BookListView() {
        super("book");
    }

    @Override
    public void showHead() {
        System.out.println("Name  Author  Year");
    }


    @Override
    public void showThings(List<Book> books) {
        books.forEach(book -> System.out.println(book.getName() + "  " + book.getAuthor()
                + "  " + book.getYear()));
    }
}
