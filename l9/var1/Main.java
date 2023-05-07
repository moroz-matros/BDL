package l9.var1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collection<String> myList = Arrays.asList("Hello lala", "World pp", "This", "Is", "Summer time");

        // 13. Задана коллекция строк. Вернуть два элемента начиная со второго.
        List<String> sublist = myList.stream().skip(1).limit(2).collect(Collectors.toList());
        System.out.println(sublist);

        // 14. Задана коллекция строк. Отсортировать значения по алфавиту в обратном
        // порядке.
        sublist = myList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sublist);
    }
}
