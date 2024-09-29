package Factory;

public abstract class CoffeeTypeFactory {
    public abstract CoffeeType createCoffeeType();

    public void orderCoffee() {
        CoffeeType coffeetype = createCoffeeType();
        coffeetype.prepare();
    }
}
