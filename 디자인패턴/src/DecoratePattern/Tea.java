package DecoratePattern;

public class Tea extends Beverage{
    public Tea() {
        this.description = "Tea";
    }

    @Override
    public double cost() {
        return 1.20;
    }
}
