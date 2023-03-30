package l4.var2_2;

// Реализовать абстрактные классы или интерфейсы, а также наследование
// и полиморфизм для следующих классов

// 4. interface Здание <- abstract class Общественное Здание <- class Театр.

public class Main {
    public static void main(String[] args) {
        Theater theater = new Theater("456 Main St.", 10, "The Fabulous Theater", 1000);

        theater.printInfo();
    }
}
