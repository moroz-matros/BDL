package l6.var1_1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* 2. Списки (стеки, очереди) I(1..n) и U(1..n) содержат результаты n
измерений тока и напряжения на неизвестном сопротивлении R.
Найти приближенное число R методом наименьших квадратов.
*/

public class Main {
    public static double calcluateResistance(List<Double> I, List<Double> U) {
        Iterator<Double> I_Iter = I.iterator();
        Iterator<Double> U_Iter = U.iterator();

        double sum_up = 0;
        double sum_down = 0;

        I_Iter = I.iterator();
        U_Iter = U.iterator();

        while (I_Iter.hasNext() && U_Iter.hasNext()) {
            double i_val = I_Iter.next();
            double u_val = U_Iter.next();
            sum_up += u_val * i_val; // IU
            sum_down += i_val * i_val; // I^2
        }

        double R = sum_up / sum_down;

        return R;
    }

    public static void main(String[] args) {
        List<Double> I = Arrays.asList(14.2, 15.3, 16.1, 15.7);
        List<Double> U = Arrays.asList(4.4, 4.9, 5.4, 5.2);
        double R = calcluateResistance(I, U);
        System.out.println(R);
    }
}
