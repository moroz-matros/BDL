package l4.var2_1;

// Реализовать абстрактные классы или интерфейсы, а также наследование
// и полиморфизм для следующих классов

// 3. interface Сотрудник <- class Инженер <- class Руководитель.

public class Main {
    public static void main(String[] args) {
        Engineer engineer = new Engineer("Sam", 100000.00);
        Director director = new Director("John", 200000.00, 50000.00);

        engineer.work();
        engineer.getPaid();
        director.work();
        director.getPaid();
    }
}
