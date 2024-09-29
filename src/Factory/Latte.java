package Factory;

public class Latte implements CoffeeType {
    @Override
    public void prepare() {
        System.out.println("Готовим Латте");
    }
}
