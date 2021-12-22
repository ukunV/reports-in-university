package Singleton.subclass;

public class SingletonTestDrive {
    public static void main(String[] args) {
        SSingleton foo = CoolerSingleton.getInstance();
        System.out.println(foo.getDescription());
        System.out.println(foo);
        SSingleton bar = HotterSingleton.getInstance();
        System.out.println(bar.getDescription());
        System.out.println(bar);
    }
}
