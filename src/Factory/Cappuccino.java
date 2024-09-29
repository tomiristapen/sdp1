package Factory;

public class Cappuccino implements CoffeeType {
    @Override
    public void prepare() {
        System.out.println("Готовим Капучино");
    }
}
