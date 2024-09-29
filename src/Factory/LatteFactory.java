package Factory;

public class LatteFactory extends CoffeeTypeFactory {
    @Override
    public CoffeeType createCoffeeType() {
        return new Latte();
    }
}