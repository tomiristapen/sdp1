package AbstractFactory;

public class Cappuccino extends Coffee {
    CoffeeIngredientFactory ingredientFactory; // Фабрика для создания ингредиентов кофе

    public Cappuccino(CoffeeIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        this.name = "Капучино с ингредиентами";
        prepare(); // Вызов метода prepare для установки ингредиентов
    }

    // Переопределяем метод prepare для установки молока и сиропа
    @Override
    public void prepare() {
        System.out.println("Готовится " + getName());
        milk = ingredientFactory.createMilk(); // Создание молока через фабрику
        syrup = ingredientFactory.createSyrup(); // Создание сиропа через фабрику
    }

    // Переопределяем getDescription, если это необходимо
    @Override
    public String getDescription() {
        return super.toString(); // Возвращаем строковое представление из родительского класса
    }
}
