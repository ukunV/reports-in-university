package TemplateMethod;

public abstract class Caffeine {
    void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if(hookCondition()) add();
    }

    public void boilWater() {
        System.out.println("Boiling water");
    }

    public abstract void brew();

    public void pourInCup() {
        System.out.println("Pouring into cup");
    }

    public abstract void add();

    public Boolean hookCondition() {
        /* get user input if no -> false */
        return false;
    }
}
