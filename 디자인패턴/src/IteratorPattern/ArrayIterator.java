package IteratorPattern;

public class ArrayIterator implements Iterator {
    private MenuItem[] menuItems;
    private int currentPosition = 0;

    public ArrayIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return (menuItems.length > currentPosition && menuItems[currentPosition] != null);
    }

    @Override
    public MenuItem next() {
        return menuItems[currentPosition++];
    }
}
