package l3.var3_1;

/*
 * Создать приложение, удовлетворяющее требованиям, приведенным в задании.
 * Аргументировать принадлежность классу каждого создаваемого метода и корректно
 * переопределить для каждого класса методы equals(), hashCode(), toString().
 *
 * 3. Создать объект класса Простая дробь, используя класс Число.
 * Методы: вывод на экран, сложение, вычитание, умножение, деление.
 */

public class Main {
    public static void main(String[] args) {
        SimpleFraction sf1 = new SimpleFraction(3, 4);
        SimpleFraction sf2 = new SimpleFraction(10, 12);

        System.out.printf("Sum: %s\n", sf1.Sum(sf2));
        System.out.printf("Subs: %s\n", sf1.Substract(sf2));
        System.out.printf("Mul: %s\n", sf1.Multiply(sf2));
        System.out.printf("Div: %s\n", sf1.Divide(sf2));
        System.out.printf("Equals: %b\n", sf1.equals(sf2));
    }
}
