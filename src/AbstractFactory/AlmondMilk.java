package AbstractFactory;

// Класс AlmondMilk реализует интерфейс Milk
public class AlmondMilk implements Milk {
    // Переопределяем метод getDescription для возврата описания миндального молока
    @Override
    public String getDescription() {
        return "Миндальное молоко"; // Возвращаем строку с описанием миндального молока
    }
}


