package Singleton.subclass;

public class HotterSingleton extends SSingleton {
    private HotterSingleton() {super();};

    public String getDescription() {
        return "I'm a thread safe hotter Singleton!";
    }
}
