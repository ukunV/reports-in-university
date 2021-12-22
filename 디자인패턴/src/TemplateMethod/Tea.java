package TemplateMethod;

public class Tea extends Caffeine {
    public void steepTeaBag() {
        System.out.println("Steeping the tea");
    }

    public void addLemon() {
        System.out.println("Adding Lemon");
    }

    @Override
    public void brew() {
        steepTeaBag();
    }

    @Override
    public void add() {
        addLemon();
    }
}
