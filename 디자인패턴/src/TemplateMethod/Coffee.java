package TemplateMethod;

public class Coffee extends Caffeine{
    @Override
    public void brew() {
        brewCoffeeGrinds();
    }
    public void brewCoffeeGrinds() {
        System.out.println("Dripping Coffee Through filter");
    }

    @Override
    public void add() {
        addSugarAndMilk();
    }

    public void addSugarAndMilk() {
        System.out.println("Adding Sugar and Milk");
    }
}
