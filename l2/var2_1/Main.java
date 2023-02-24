package l2.var2_1;

import java.util.Random;
import java.util.Scanner;

// Ввести с консоли n – размерность матрицы a[n][n].
// Задать значения элементов матрицы в интервале
// значений от -n до n с помощью датчика случайных чисел.

// 3. Найти и вывести наибольшее число возрастающих (убывающих)
// элементов матрицы, идущих подряд.

public class Main {

    private static void manageMaximum(int[] nums) {
        if (nums[0] > nums[1]) {
            nums[1] = nums[0];
        }

        nums[0] = 1;
    }

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

        if (n < 1) {
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

        // store current in nums[0] and max in nums[1]
        int[] incNums = { 1, 1 };
        int[] decNums = { 1, 1 };
        int prev = arr[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] < prev) {
                    decNums[0] += 1;
                    manageMaximum(incNums);
                } else if (arr[i][j] > prev) {
                    incNums[0] += 1;
                    manageMaximum(decNums);
                } else {
                    manageMaximum(incNums);
                    manageMaximum(decNums);
                }

                prev = arr[i][j];
            }
        }

        System.out.printf("Max inc nums are %d nums in a row\n", incNums[1]);
        System.out.printf("Max dec nums are %d nums in a row\n", decNums[1]);
    }
}
