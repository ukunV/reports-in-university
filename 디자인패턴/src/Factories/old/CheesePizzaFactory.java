package Factories.old;

public class CheesePizzaFactory extends PizzaFactory {
    @Override
    public Pizza getInstance() {
        return new CheesePizza();
    }
}
