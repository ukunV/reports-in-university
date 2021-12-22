package TemplateMethod;

public class Main {
    public static void main(String[] args) {
        Caffeine myCoffee = new Coffee();
        Caffeine myTea = new Tea();

        myCoffee.prepareRecipe();
        myTea.prepareRecipe();
    }
}
