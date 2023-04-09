package l5.var2_1;

/*  Выполнить задания из варианта 2 лабораторной работы 3,
    реализуя собственные обработчики исключений и исключения ввода/вывода.
 */

public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient(1, "Smith", "John", "James", "123 Main St", "", 9, "fever");
        try {
            patient.setPhoneNumber("8800555353");
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
