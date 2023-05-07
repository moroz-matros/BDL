package l9.var2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        // 13. Задана коллекция строк. Убрать первый символ и вернуть числа.
        List<String> result = collection.stream()
                .map(s -> s.substring(1))
                .filter(s -> s.matches("\\d+"))
                .collect(Collectors.toList());
        System.out.println(result);

        // 14. Задана коллекция строк. Добавить к каждой строке “_task14”.
        result = collection.stream()
                .map(s -> s + "_task14")
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
