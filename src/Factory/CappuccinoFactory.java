package Factory;

public class CappuccinoFactory extends CoffeeTypeFactory {
    @Override
    public CoffeeType createCoffeeType() {
        return new Cappuccino();
    }
}
