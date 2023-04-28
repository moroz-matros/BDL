package l6.var1_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* 3. С использованием множества выполнить попарное суммирование
произвольного конечного ряда чисел по следующим правилам:
на первом этапе суммируются попарно рядом стоящие числа,
на втором этапе суммируются результаты первого этапа и т.д. до тех пор, пока не останется одно число.
*/

public class Main {
    public static int pairSum(List<Integer> nums) {
        Set<Integer> s = new LinkedHashSet<>(nums);
        Set<Integer> newS = new LinkedHashSet<>();
        Iterator<Integer> it = s.iterator();

        while (s.size() > 1) {
            Integer n1 = it.next();
            while (it.hasNext()) {
                Integer n2 = it.next();
                newS.add(n1 + n2);
                n1 = n2;
            }
            s = new LinkedHashSet<>(newS);
            it = s.iterator();

            newS.clear();
        }
        return s.iterator().next();
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> nums2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        List<Integer> nums3 = new ArrayList<Integer>(Arrays.asList(1));
        int sum = pairSum(nums);
        int sum2 = pairSum(nums2);
        int sum3 = pairSum(nums3);
        System.out.println("The pairwise sum of the list is: " + sum);
        System.out.println("The pairwise sum of the list2 is: " + sum2);
        System.out.println("The pairwise sum of the list3 is: " + sum3);
    }
}
