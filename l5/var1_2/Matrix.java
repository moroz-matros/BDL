package l5.var1_2;

public class Matrix {
    private int n;
    private int[][] arr;

    public Matrix(int n) {
        this.n = n;
        this.arr = new int[n][n];
    }

    public void setArr(int[][] arr) {
        this.arr = arr;
        this.n = arr[0].length;
    }

    public Matrix(int[][] arr) {
        this.n = arr[0].length;
        this.arr = arr;
    }

    public Matrix add(Matrix m) {
        int[][] arr = new int[this.n][this.n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = this.arr[i][j] + m.arr[i][j];
            }
        }

        return new Matrix(arr);
    }

    public Matrix substract(Matrix m) throws Exception {
        int[][] arr = new int[this.n][this.n];
        try {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = this.arr[i][j] - m.arr[i][j];
                }
            }
        } catch (Exception e) {
            System.out.printf("%s\n", e.toString());
            throw e;
        }
        return new Matrix(arr);
    }

    public Matrix multiplication(Matrix m) {
        int[][] arr = new int[this.n][this.n];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                for (int k = 0; k < this.n; k++) {
                    arr[i][j] += this.arr[i][k] * m.arr[k][j];
                }
            }
        }

        return new Matrix(arr);
    }

    public int getFirstNorm() {
        int max = 0, sum = 0;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                sum += this.arr[i][j];
            }
            if (sum > max) {
                max = sum;
            }
            sum = 0;
        }

        return max;
    }

    public int getSecondNorm() {
        int max = 0, sum = 0;
        for (int j = 0; j < this.n; j++) {
            for (int i = 0; i < this.n; i++) {
                sum += this.arr[i][j];
            }
            if (sum > max) {
                max = sum;
            }
            sum = 0;
        }

        return max;
    }

    public void printMatrix() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                System.out.printf("%d ", this.arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
