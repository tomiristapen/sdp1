package Builder;

import AbstractFactory.Syrup;
import AbstractFactory.Milk;
import AbstractFactory.Coffee;
import AbstractFactory.Cappuccino;
import AbstractFactory.Latte;
import AbstractFactory.CoffeeIngredientFactory;

public class CoffeeBuilder {
    private Class<? extends Coffee> coffeeClass; // Класс кофе
    private Milk milk; // Молоко
    private Syrup syrup; // Сироп

    public CoffeeBuilder setCoffeeClass(Class<? extends Coffee> coffeeClass) {
        this.coffeeClass = coffeeClass; // Установка класса кофе
        return this;
    }

    public CoffeeBuilder setMilk(Milk milk) {
        this.milk = milk; // Установка молока
        return this;
    }

    public CoffeeBuilder setSyrup(Syrup syrup) {
        this.syrup = syrup; // Установка сиропа
        return this;
    }

    public Coffee build() {
        Coffee customCoffee = null;
        CoffeeIngredientFactory ingredientFactory = new CustomIngredientFactory(milk, syrup); // Создание фабрики

        try {
            // Создание кофе в зависимости от типа
            if (coffeeClass.equals(Cappuccino.class)) {
                customCoffee = new Cappuccino(ingredientFactory);
            } else if (coffeeClass.equals(Latte.class)) {
                customCoffee = new Latte(ingredientFactory);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Логирование ошибок
        }

        return customCoffee; // Возвращает готовый объект кофе
    }
}
