package l2.var1_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// В приведенных ниже заданиях необходимо вывести внизу фамилию разработчика,
// дату и время получения задания, а также дату и время сдачи задания.
// Для получения последней даты и времени следует использовать класс Date.

// 3. Ввести n строк с консоли. Вывести на консоль те строки, длина которых меньше
// (больше) средней, а также длину.

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss\n");
        Date dateRecived = new Date((long) 1676630654 * 1000); // Fri Feb 17 2023 13:44:14 GMT+0300

        System.out.println("Made by Morozova");
        System.out.printf("The task received at %s", df.format(dateRecived));

        System.out.println("Enter n:");
        int n = 0;
        try {
            n = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
        }

        if (n < 2) {
            System.out.println("Invalid n");
            in.close();
            return;
        }

        String[] arr = new String[n];

        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLine();
        }

        in.close();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i].length();
        }

        int avg = sum / n;

        System.out.printf("The length is less than average %d:\n", avg);
        for (int i = 0; i < n; i++) {
            if (arr[i].length() < avg) {
                System.out.printf("%s with length %d\n", arr[i], arr[i].length());
            }
        }

        System.out.printf("The length is greater than average %d:\n", avg);
        for (int i = 0; i < n; i++) {
            if (arr[i].length() > avg) {
                System.out.printf("%s with length %d\n", arr[i], arr[i].length());
            }
        }

        System.out.printf("The task completed at %s", df.format(new Date()));
    }
}
