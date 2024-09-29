package AbstractFactory;

public class RegularMilk implements Milk {
    // Возвращает описание обычного молока
    @Override
    public String getDescription() {
        return "Простое молоко";
    }
}
