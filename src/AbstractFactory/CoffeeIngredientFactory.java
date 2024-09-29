package AbstractFactory;

// Интерфейс для создания ингредиентов кофе
public interface CoffeeIngredientFactory {
    // Метод для создания молока
    Milk createMilk();

    // Метод для создания сиропа
    Syrup createSyrup();
}
