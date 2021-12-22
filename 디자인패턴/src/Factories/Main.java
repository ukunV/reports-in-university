package Factories;

public class Main {

    public static void main(String[] args) {
//        old.PizzaFactory myFactory = new old.VeggiePizzaFactory();
//        old.Pizza pizza = myFactory.preparePizza();
//        System.out.println("We ordered a " + pizza.getName() + "\n");
//        System.out.println(pizza);

        PizzaStore store = new NYPizzaStore();

        Pizza pizza = store.orderPizza("cheese");
        System.out.println("We ordered a " + pizza.getName() + "\n");
        System.out.println(pizza);

        pizza = store.orderPizza("veggie");
        System.out.println("We ordered a " + pizza.getName() + "\n");
        System.out.println(pizza);
    }
}
