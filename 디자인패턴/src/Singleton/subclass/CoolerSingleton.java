package Singleton.subclass;

public class CoolerSingleton extends SSingleton {
    protected static SSingleton uniqueInstance;

    private CoolerSingleton() {super();};

    public String getDescription() {
        return "I'm a thread safe cooler Singleton!";
    }
}
