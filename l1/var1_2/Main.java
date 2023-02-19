package l1.var1_2;

import java.util.Arrays;

// 2. Создать приложение, которое отображает в окне консоли аргументы командной строки
// метода main() в обратном порядке.

public class Main {
    public static void main(String[] args) {
        int i = 0;
        int j = args.length - 1;
        while (i < j) {
            String arg = args[i];
            args[i] = args[j];
            args[j] = arg;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(args));
    }
}
