package l5.var2_2;

/*  Выполнить задания из варианта 2 лабораторной работы 3,
    реализуя собственные обработчики исключений и исключения ввода/вывода.
 */

public class Main {
    public static void main(String[] args) {
        Abiturient abiturient = new Abiturient(1, "Ivanov", "Ivan", "Ivanovich", "123 Main St", "1234567",
                new float[] { 3, 4, 5, 1 });
        try {
            abiturient.setPhoneNumber("8800555353");
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
