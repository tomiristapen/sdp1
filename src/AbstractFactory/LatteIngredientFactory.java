package AbstractFactory;

public class LatteIngredientFactory implements CoffeeIngredientFactory {
    @Override
    public Milk createMilk() {
        return new RegularMilk();
    }

    @Override
    public Syrup createSyrup() {
        return new ChocolateSyrup();
    }

}

