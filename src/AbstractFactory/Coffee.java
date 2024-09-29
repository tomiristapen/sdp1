package AbstractFactory;

// Абстрактный класс для кофе, реализующий Cloneable для клонирования объектов
public abstract class Coffee implements Cloneable {
    String name;
    Milk milk;
    Syrup syrup;

    // Абстрактный метод для приготовления кофе
    public abstract void prepare();

    // Метод для установки имени кофе
    public void setName(String name) {
        this.name = name;
    }

    // Метод для получения имени кофе
    public String getName() {
        return name;
    }

    // Метод для получения молока
    public Milk getMilk() {
        return milk;
    }

    // Метод для получения сиропа
    public Syrup getSyrup() {
        return syrup;
    }

    // Метод для получения описания кофе
    public String getDescription() {
        return name + " с " + milk.getDescription() + " и " + syrup.getDescription();
    }

    // Переопределение метода toString для вывода описания
    @Override
    public String toString() {
        return getDescription();
    }

    // Метод для клонирования объекта кофе
    @Override
    public Coffee clone() {
        try {
            Coffee cloned = (Coffee) super.clone(); // Клонирование текущего объекта
            // Предполагается, что Milk и Syrup являются неизменяемыми
            // Если они требуют глубокого копирования, необходимо реализовать методы clone() в Milk и Syrup.
            return cloned;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null; // Возврат null в случае ошибки клонирования
        }
    }
}

