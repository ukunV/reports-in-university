package IteratorPattern;

import java.util.ArrayList;

public class ArrayListIterator implements Iterator {
    int currentPosition = 0;
    private ArrayList myArrayList;


    public ArrayListIterator(ArrayList arrayList) {
        myArrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
        return myArrayList.size() > currentPosition;
    }

    @Override
    public MenuItem next() {
        return (MenuItem)myArrayList.get(currentPosition++);
    }
}
