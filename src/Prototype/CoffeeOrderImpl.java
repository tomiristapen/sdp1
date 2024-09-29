package Prototype;

import AbstractFactory.CoffeeIngredientFactory;

public class CoffeeOrderImpl implements CoffeeOrder {
    private String coffeeType;
    private CoffeeIngredientFactory ingredientFactory;

    public CoffeeOrderImpl(String coffeeType, CoffeeIngredientFactory ingredientFactory) {
        this.coffeeType = coffeeType;
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public CoffeeOrder clone() { // Реализация метода clone
        // Создаем новый объект CoffeeOrderImpl с теми же значениями
        return new CoffeeOrderImpl(this.coffeeType, this.ingredientFactory);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + coffeeType);
        ingredientFactory.createMilk();
        ingredientFactory.createSyrup();
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public CoffeeIngredientFactory getIngredientFactory() {
        return ingredientFactory;
    }
}
