package l5.var1_2;

import java.util.Random;

// Выполнить задания на основе варианта 1 лабораторной работы 3,
// контролируя состояние потоков ввода/вывода. При возникновении ошибок,
// связанных с корректностью выполнения математических операций, генерировать и
// обрабатывать исключительные ситуации. Предусмотреть обработку исключений,
// возникающих при нехватке памяти, отсутствии требуемой записи (объекта) в файле,
// недопустимом значении поля и т.д.

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
        int l1 = 10;
        int l2 = 4;
        Matrix arr1 = new Matrix(getRandomMatrix(l1));
        Matrix arr2 = new Matrix(getRandomMatrix(l2));

        try {
            arr1.substract(arr2);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
