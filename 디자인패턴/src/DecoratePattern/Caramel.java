package DecoratePattern;

public class Caramel extends Condiment{
    public Caramel(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .25 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Caramel";
    }
}