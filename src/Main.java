import java.util.Scanner;
import Builder.CoffeeBuilder;
import AbstractFactory.RegularMilk;
import AbstractFactory.AlmondMilk;
import AbstractFactory.ChocolateSyrup;
import AbstractFactory.CaramelSyrup;
import AbstractFactory.Coffee;
import AbstractFactory.Cappuccino;
import AbstractFactory.Latte;
import Singleton.Cafe;
import AbstractFactory.Milk;
import AbstractFactory.Syrup;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cafe cafe = Cafe.getInstance(); // Получение экземпляра синглтона
        System.out.println("Добро пожаловать в наше кафе!");

        // Выбор кофе
        System.out.println("Выберите кофе:");
        System.out.println("1. Капучино");
        System.out.println("2. Латте");
        System.out.println("3. Кастомное кофе");

        int choice = scanner.nextInt();
        System.out.println("Сколько чашек?");
        int cups = scanner.nextInt();

        Coffee coffeeOrder = null;
        Syrup syrup = null;
        Milk milk = null;
        String coffeeType = null;

        switch (choice) {
            case 1:
                coffeeOrder = new CoffeeBuilder()
                        .setCoffeeClass(Cappuccino.class)
                        .setMilk(new RegularMilk())
                        .setSyrup(new CaramelSyrup())
                        .build();
                syrup = new CaramelSyrup();
                milk = new RegularMilk();
                coffeeType = "капучино";
                break;
            case 2:
                coffeeOrder = new CoffeeBuilder()
                        .setCoffeeClass(Latte.class)
                        .setMilk(new RegularMilk())
                        .setSyrup(new ChocolateSyrup())
                        .build();
                syrup = new ChocolateSyrup();
                milk = new RegularMilk();
                coffeeType = "латте";
                break;
            case 3:
                // Создание кастомного кофе
                System.out.println("Создание кастомного кофе:");
                System.out.println("Выберите тип кофе:");
                System.out.println("1. Капучино");
                System.out.println("2. Латте");
                int customCoffeeChoice = scanner.nextInt();

                Class<? extends Coffee> customCoffeeClass = null;
                switch (customCoffeeChoice) {
                    case 1:
                        customCoffeeClass = Cappuccino.class;
                        break;
                    case 2:
                        customCoffeeClass = Latte.class;
                        break;
                    default:
                        System.out.println("Неверный выбор.");
                        return;
                }

                // Выбор молока
                System.out.println("Теперь выберите молоко:");
                System.out.println("1. Обычное молоко");
                System.out.println("2. Миндальное молоко");
                int milkChoice = scanner.nextInt();
                milk = (milkChoice == 1) ? new RegularMilk() : new AlmondMilk();

                // Выбор сиропа
                System.out.println("Теперь выберите сироп:");
                System.out.println("1. Карамельный сироп");
                System.out.println("2. Шоколадный сироп");
                int syrupChoice = scanner.nextInt();
                syrup = (syrupChoice == 1) ? new CaramelSyrup() : new ChocolateSyrup();

                // Создание кастомного заказа
                coffeeOrder = new CoffeeBuilder()
                        .setCoffeeClass(customCoffeeClass)
                        .setMilk(milk)
                        .setSyrup(syrup)
                        .build();
                coffeeType = customCoffeeClass.getSimpleName().toLowerCase();
                break;
            default:
                System.out.println("Неверный выбор.");
                return;
        }

        // Отображение информации о заказе
        if (coffeeOrder != null) {
            for (int i = 0; i < cups; i++) {
                Coffee clonedOrder = coffeeOrder.clone(); // Клонирование заказа
                if (clonedOrder != null) {
                    clonedOrder.prepare(); // Приготовление клонированного заказа
                    System.out.println("Клонирование заказа #" + (i + 1) + ": " + coffeeType + " с " + syrup.getDescription() + " и " + milk.getDescription());
                } else {
                    System.out.println("Ошибка клонирования.");
                }
            }
            System.out.println("Ваш заказ: " + cups + " чашек " + coffeeType + " с " + syrup.getDescription() + " и " + milk.getDescription() + " готов.");
        } else {
            System.out.println("Не удалось создать заказ.");
        }

        System.out.println("Спасибо за ваш заказ!");
        scanner.close();
    }
}