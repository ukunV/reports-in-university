package IteratorPattern;

public class Main {
    public static void main(String[] args) {
        PancakeHouseMenu myMenu = new PancakeHouseMenu();
        DinerMenu yourMenu = new DinerMenu();


        Iterator menu = new ArrayListIterator(myMenu.getMenuItems());
        while(menu.hasNext()) {
            MenuItem menuItem = menu.next();
            System.out.print(menuItem.getName());
            System.out.println("\t\t" + menuItem.getPrice());
            System.out.println("\t" + menuItem.getDescription());
        }

        System.out.println();

        menu = new ArrayIterator(yourMenu.getMenuItems());
        while(menu.hasNext()) {
            MenuItem menuItem = menu.next();
            System.out.print(menuItem.getName());
            System.out.println("\t\t" + menuItem.getPrice());
            System.out.println("\t" + menuItem.getDescription());
        }
    }
}
