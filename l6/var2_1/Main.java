package l6.var2_1;

import java.io.BufferedReader;
import java.io.FileReader;

/* 3. Во входном файле хранятся две разреженные матрицы А и В.
Построить циклически связанные списки СА и СВ, содержащие ненулевые элементы
 соответственно матриц А и В. Просматривая списки, вычислить: а) сумму S = A + B;
 б) произведение P = A * B.
*/

public class Main {
    public static void main(String[] args) {
        int m = 3, n = 3;

        int[][] matA = new int[m][n];
        int[][] matB = new int[m][n];
        try {
            // read matA and matB from text files
            BufferedReader brA = new BufferedReader(new FileReader("l6/var2_1/matA.txt"));
            BufferedReader brB = new BufferedReader(new FileReader("l6/var2_1/matB.txt"));
            String stA;
            int i = 0, j = 0;

            while ((stA = brA.readLine()) != null) {
                String[] matAStr = stA.split(" ");
                j = 0;

                for (String s : matAStr) {
                    matA[i][j++] = Integer.parseInt(s);
                }
                i++;
            }
            brA.close();

            i = 0;
            String stB;
            while ((stB = brB.readLine()) != null) {
                String[] matBStr = stB.split(" ");
                j = 0;

                for (String s : matBStr) {
                    matB[i][j++] = Integer.parseInt(s);
                }
                i++;
            }
            brB.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        SparseMatrix spA = new SparseMatrix(matA);
        SparseMatrix spB = new SparseMatrix(matB);
        spA.print();
        System.out.println();
        spB.print();
        System.out.println();

        SparseMatrix S = spA.sum(spB);
        S.print();
        System.out.println();

        SparseMatrix P = spA.multiply(spB);
        P.print();
    }
}
