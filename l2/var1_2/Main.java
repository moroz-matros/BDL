package l2.var1_2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// В приведенных ниже заданиях необходимо вывести внизу фамилию разработчика,
// дату и время получения задания, а также дату и время сдачи задания.
// Для получения последней даты и времени следует использовать класс Date.

// 4. Ввести n слов с консоли. Найти слово, в котором число различных символов минимально.
// Если таких слов несколько, найти первое из них.

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss\n");
        Date dateRecived = new Date((long) 1676630654 * 1000); // Fri Feb 17 2023 13:44:14 GMT+0300

        System.out.println("Made by Morozova");
        System.out.printf("The task received at %s", df.format(dateRecived));

        System.out.println("Enter n:");
        int n;
        try {
            n = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            n = 0;
        }

        if (n < 1) {
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

        long minimum = arr[0].chars().distinct().count();
        int minimumIdx = 0;
        for (int i = 1; i < n; i++) {
            long lenDiff = arr[i].chars().distinct().count();
            if (lenDiff < minimum) {
                minimum = lenDiff;
                minimumIdx = i;
            }
        }

        System.out.printf("The first minimum unique symbols has word " +
                "%s with %d unique symbols\n", arr[minimumIdx], minimum);

        System.out.printf("The task completed at %s", df.format(new Date()));
    }
}
