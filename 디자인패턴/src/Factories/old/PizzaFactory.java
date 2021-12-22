package Factories.old;

public abstract class PizzaFactory {
    public abstract Pizza getInstance();
    public Pizza preparePizza() {
        Pizza pizza = getInstance();

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
