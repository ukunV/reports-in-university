package DecoratePattern;

public class Main {

    public static void main(String[] args) {
        Beverage myBeverage = new HouseBlend();
        myBeverage = new Milk(myBeverage);
        myBeverage = new Whip(myBeverage);
        myBeverage = new Soy(myBeverage);
        System.out.println(myBeverage.getDescription() + " $" + myBeverage.cost());

        Beverage yourBeverage = new DarkRoast();
        yourBeverage = new Mocha(yourBeverage);
        yourBeverage = new Whip(yourBeverage);
        System.out.println(yourBeverage.getDescription() + " $" + yourBeverage.cost());

        Beverage hisBeverage = new Tea();
        hisBeverage = new Soy(hisBeverage);
        System.out.println(hisBeverage.getDescription() + " $" + hisBeverage.cost());

        Beverage herBeverage = new Espresso();
        herBeverage = new Caramel(herBeverage);
        herBeverage = new Whip(herBeverage);
        System.out.println(herBeverage.getDescription() + " $" + herBeverage.cost());
    }
}
