package AdaptorPattern;

public class WildTurkeyAdaptor extends WildTurkey implements Duck {
    @Override
    public void quack() {
        gobble();
    }

    @Override
    public void fly() {
        for(int i = 0; i < 5; i++) {
            super.fly();
        }
    }
}
