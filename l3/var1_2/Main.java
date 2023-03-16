package l3.var1_2;

import java.util.Random;

/* 4. Определить класс Матрица размерности (n x n). Класс должен содержать несколько конструкторов.
 * Реализовать методы для сложения, вычитания, умножения матриц. Объявить массив объектов.
 * Создать методы, вычисляющие первую и вторую нормы матрицы
 */

public class Main {
    public static int[][] getRandomMatrix(int size) {
        int[][] arr = new int[size][size];
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = r.nextInt(11) - 5;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int n = 4;
        int l = 2;
        int s = l + 4;
        Matrix[] arr = new Matrix[s];
        for (int i = 0; i < l; i++) {
            arr[i] = new Matrix(getRandomMatrix(n));
        }

        arr[l] = new Matrix(n);
        arr[l].setArr(getRandomMatrix(n));

        arr[l + 1] = arr[1].add(arr[2]);
        arr[l + 2] = arr[2].substract(arr[3]);
        arr[l + 3] = arr[3].multiplication(arr[4]);

        for (int i = 0; i < s; i++) {
            arr[i].printMatrix();
        }

        // { value, idx }
        int[] firstMin = { arr[0].getFirstNorm(), 0 };
        int[] secondMin = { arr[0].getSecondNorm(), 0 };

        for (int i = 1; i < s; i++) {
            if (arr[i].getFirstNorm() < firstMin[0]) {
                firstMin[0] = arr[i].getFirstNorm();
                firstMin[1] = i;
            }

            if (arr[i].getSecondNorm() < secondMin[0]) {
                secondMin[0] = arr[i].getSecondNorm();
                secondMin[1] = i;
            }
        }

        System.out.printf("First norm %d in\n", firstMin[0]);
        arr[firstMin[1]].printMatrix();

        System.out.printf("Second norm %d in\n", secondMin[0]);
        arr[secondMin[1]].printMatrix();
    }
}
