package l2.var2_2;

import java.util.Random;
import java.util.Scanner;

// Ввести с консоли n – размерность матрицы a[n][n].
// Задать значения элементов матрицы в интервале
// значений от -n до n с помощью датчика случайных чисел.

// 4. Найти сумму элементов матрицы, расположенных между первым и
// вторым положительными элементами каждой строки.

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter n:");
        int n;
        try {
            n = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            n = 0;
        }

        in.close();

        // 3 elems at least
        if (n < 3) {
            System.out.println("Invalid n");
            return;
        }

        int[][] arr = new int[n][n];

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = rand.nextInt(2 * n + 1) - n;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // store current in nums[0] and max in nums[1]
        int[] sums = new int[n];

        for (int i = 0; i < n; i++) {
            boolean startedToSum = false;
            boolean alreadySummed = false;

            for (int j = 0; j < n; j++) {
                if (arr[i][j] >= 0) {

                    // found first positive
                    if (!startedToSum && !alreadySummed) {
                        startedToSum = true;
                        continue;
                    }
                    // found second positive, cause already started to sum
                    if (startedToSum) {
                        startedToSum = false;
                        alreadySummed = true;
                    }
                } else if (startedToSum) {
                    sums[i] += arr[i][j];
                }
            }

            // didn't find second positive
            if (!alreadySummed && startedToSum) {
                sums[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(sums[i] + " ");
        }
    }
}
