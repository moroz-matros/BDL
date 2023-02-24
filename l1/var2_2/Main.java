package l1.var2_2;

import java.util.Scanner;

// Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести:
// 14. Элементы, которые равны полусумме соседних элементов.

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter n:");
        int n = in.nextInt();
        if (n < 3) {
            System.out.println("Not enough elements, plz enter 3 or more");
            in.close();
            return;
        }

        int[] arr = new int[n];

        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        in.close();

        for (int i = 1; i < n - 1; i++) {
            if (arr[i] == (arr[i - 1] + arr[i + 1]) / 2) {
                System.out.printf("%d is (%d + %d) / 2\n", arr[i], arr[i - 1], arr[i + 1]);
            }
        }
    }
}
