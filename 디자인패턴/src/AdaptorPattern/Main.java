package AdaptorPattern;

public class Main {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
//        Duck turkey = new TurkeyAdaptor(new WildTurkey());
        Duck turkey = new WildTurkeyAdaptor();

        System.out.println("I'm a duck");
        duck.quack();
        duck.fly();

        System.out.println();

        System.out.println("I'm turkey");
        turkey.quack();
        turkey.fly();
    }
}
