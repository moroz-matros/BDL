package l3.var3_2;

/*
 * Создать приложение, удовлетворяющее требованиям, приведенным в задании.
 * Аргументировать принадлежность классу каждого создаваемого метода и корректно
 * переопределить для каждого класса методы equals(), hashCode(), toString().
 *
 * 4. Создать объект класса Дом, используя классы Окно, Дверь.
 * Методы: закрыть на ключ, вывести на консоль количество окон, дверей.
 */

public class Main {
    public static void main(String[] args) {
        House h = new House(new Window(3), new Door(4));

        System.out.printf("House: %s\n", h);
        h.DoorNumOutput();
        h.WindowsNumOutput();
        h.LockWithKey();
        System.out.printf("House: %s\n", h);
    }
}
