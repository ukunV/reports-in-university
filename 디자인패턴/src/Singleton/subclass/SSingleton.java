package Singleton.subclass;

public class SSingleton {
    protected static SSingleton uniqueInstance = null;

    protected SSingleton() {}

    public static synchronized SSingleton getInstance() {
        if(uniqueInstance == null) uniqueInstance = new SSingleton();

        return uniqueInstance;
    }

    public String getDescription() {
        return "I'm a thread safe Singleton!";
    }
}
