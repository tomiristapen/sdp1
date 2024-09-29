package Prototype;

public interface CoffeeOrder extends Cloneable {
    CoffeeOrder clone(); // Метод для клонирования
    void prepare(); // Метод для приготовления кофе
}
