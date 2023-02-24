package l1.var2_1;

import java.util.Scanner;

// Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести:
// 13. Числа-палиндромы, значения которых в прямом и обратном порядке совпадают.

public class Main {
    public static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter n:");
        int n = in.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        in.close();

        System.out.println("Palindromes are:");
        boolean noPalindromes = true;
        for (int i = 0; i < n; i++) {
            if (isPalindrome(arr[i])) {
                System.out.printf("%d\n", arr[i]);
                noPalindromes = false;
            }
        }

        if (noPalindromes) {
            System.out.println("No palindromes :(");
        }
    }
}
