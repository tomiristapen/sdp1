package AbstractFactory;

public class Latte extends Coffee {
    CoffeeIngredientFactory ingredientFactory; // Фабрика для создания ингредиентов

    // Конструктор, принимающий фабрику
    public Latte(CoffeeIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        this.name = "Латте"; // Название кофе
        prepare(); // Подготовка ингредиентов
    }

    // Метод для подготовки молока и сиропа
    @Override
    public void prepare() {
        System.out.println("Готовится " + getName());
        milk = ingredientFactory.createMilk(); // Создание молока
        syrup = ingredientFactory.createSyrup(); // Создание сиропа
    }

    // Возвращает описание кофе
    @Override
    public String getDescription() {
        return super.toString(); // Использует toString из Coffee
    }
}

