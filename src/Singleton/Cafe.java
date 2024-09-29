package Singleton;
public class Cafe {

    //для единственного экземпляра
    private static Cafe instance;

    // Приватный конструктор предотвращает создание объектов извне
    private Cafe(){
        System.out.println("кафе создано");
    }

    // Метод для получения единственного экземпляра
    public static Cafe getInstance(){
        if(instance==null){
            instance=new Cafe();
        }
        return instance;
    }
    public void CoffeePrep(String coffeetype){
        System.out.println("cafe"+coffeetype);
    }
}
