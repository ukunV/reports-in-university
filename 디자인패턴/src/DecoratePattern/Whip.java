package DecoratePattern;

public class Whip extends Condiment{
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .25 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Whip";
    }
}
