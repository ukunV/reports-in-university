package Factories.old;

public class VeggiePizzaFactory extends PizzaFactory {
    @Override
    public Pizza getInstance() {
        return new VeggiePizza();
    }
}
