package Builder;

import AbstractFactory.Syrup;
import AbstractFactory.Milk;
import AbstractFactory.CoffeeIngredientFactory;

public class CustomIngredientFactory implements CoffeeIngredientFactory {
    private Milk milk; // Молоко
    private Syrup syrup; // Сироп

    public CustomIngredientFactory(Milk milk, Syrup syrup) {
        this.milk = milk; // Инициализация молока
        this.syrup = syrup; // Инициализация сиропа
    }

    @Override
    public Milk createMilk() {
        return milk; // Возвращает установленное молоко
    }

    @Override
    public Syrup createSyrup() {
        return syrup; // Возвращает установленный сироп
    }
}
