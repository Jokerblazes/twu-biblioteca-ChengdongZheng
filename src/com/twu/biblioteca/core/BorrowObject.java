package com.twu.biblioteca.core;

import com.twu.biblioteca.views.BorrowListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午3:08 2018/5/3
 */
public abstract class BorrowObject<T> {
    protected List<T> things;
    protected List<T> rentedThings;
    protected BorrowListView view;


    public BorrowObject(BorrowListView view) {
        this(new ArrayList<>(), new ArrayList<>(), view);
    }


    public BorrowObject(List<T> things, List<T> rentedThings, BorrowListView view) {
        this.things = things;
        this.rentedThings = rentedThings;
        this.view = view;
    }

    public void showThings() {
        view.showHead();
        view.showThings(things);
    }

    public T checkOutThing(String name) {
        int index = searchThings(name,things);
        return checkOutThing(index);
    }

    private T checkOutThing(int index) {
        T thing = null;
        if (index == -1) {
            view.showCheckOutFail();
        } else {
            thing = things.get(index);
            rentedThings.add(thing);
            things.remove(index);
            view.showCheckOutSuccess();
        }
        return thing;
    }

    private int searchThings(String name,List<T> target) {
        for (int i = 0; i < target.size(); i++) {
            if (compare(target.get(i), name))
                return i;
        }
        return -1;
    }

    public T returnThing(String name) {
        int index = searchThings(name,rentedThings);

        return returnThing(index);

    }

    private T returnThing(int index) {
        T thing = null;
        if (index == -1) {
            view.showReturnFail();
        } else {
            thing = rentedThings.get(index);
            things.add(thing);
            rentedThings.remove(index);
            view.showReturnSuccess();
        }
        return thing;
    }

    protected abstract boolean compare(T thing,String name);
}
