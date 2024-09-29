package AbstractFactory;

// Фабрика для создания ингредиентов капучино
public class CappuccinoIngredientFactory implements CoffeeIngredientFactory {
    @Override
    public Milk createMilk() {
        return new AlmondMilk(); // Создание миндального молока для капучино
    }

    @Override
    public Syrup createSyrup() {
        return new CaramelSyrup(); // Создание карамельного сиропа для капучино
    }
}
