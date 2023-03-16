package l3.var2_2;

import java.util.Arrays;

/*  Создать классы, спецификации которых приведены ниже.
    Определить конструкторы и методы setТип(), getТип(), toString().
    Определить дополнительно методы в классе, создающем массив объектов.
    Задать критерий выбора данных и вывести эти данные на консоль.

    4. Abiturient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Оценки.
    Создать массив объектов. Вывести: a) список абитуриентов, имеющих неудовлетворительные оценки;
    b) список абитуриентов, средний балл у которых выше заданного;
    c) выбрать заданное число n абитуриентов, имеющих самый высокий средний балл
    (вывести также полный список абитуриентов, имеющих полупроходной балл).
 */

public class Main {
    public static void main(String[] args) {
        Abiturient[] abiturients = new Abiturient[] {
                new Abiturient(1, "Ivanov", "Ivan", "Ivanovich", "123 Main St", "1234567", new float[] { 3, 4, 5, 1 }),
                new Abiturient(2, "Petrov", "Petr", "Petrovich", "123 Oak St", "2345678", new float[] { 2, 3, 4, 3 }),
                new Abiturient(3, "Sidorov", "Sidor", "Sidorovich", "345 Maple St", "3456789", new float[] { 4, 4, 4 }),
                new Abiturient(4, "Kuznetsov", "Igor", "Igorevich", "780 Main St", "4567890",
                        new float[] { 5, 4, 5, 3 }),
                new Abiturient(5, "Smirnov", "Sergey", "Sergeevich", "122 Alma St", "5678901",
                        new float[] { 3, 3, 3 }),
                new Abiturient(6, "Popov", "Andrey", "Andreevich", "788 Great St", "6789012",
                        new float[] { 3, 4, 4, 5, 5 }),
                new Abiturient(7, "Volkov", "Vladimir", "Vladimirovich", "455 Little St", "7890123",
                        new float[] { 2, 2, 2 }),
                new Abiturient(8, "Novikov", "Nikolay", "Nikolaevich", "123 Big St", "8901234",
                        new float[] { 5, 5, 5 }),
                new Abiturient(9, "Kozlov", "Dmitry", "Dmitrievich", "122 Nice St", "9012345",
                        new float[] { 3, 1, 3, 2 }),
                new Abiturient(10, "Morozov", "Alexey", "Alexeevich", "126 Main St", "0123456", new float[] { 4, 4 })
        };

        int normScore = 3;
        System.out.println("List of abiturients with score < " + normScore + ":");
        for (Abiturient abiturient : abiturients) {
            for (float score : abiturient.getScores()) {
                if (score < normScore) {
                    System.out.println(abiturient);
                    break;
                }
            }
        }

        // list of abiturients, who has average score greater that given avg=3.8
        float avg = 3.8f;
        System.out.println("List of abiturients with average score > " + avg + ":");
        for (Abiturient abiturient : abiturients) {
            if (abiturient.getAverageScore() > avg) {
                System.out.println(abiturient);
            }
        }

        // list of n=3 abiturients, who has the highest average score
        int n = 3;
        Abiturient[] sortedAbiturients = Arrays.copyOf(abiturients, abiturients.length);
        Arrays.sort(sortedAbiturients, (a1, a2) -> Float.compare(a2.getAverageScore(), a1.getAverageScore()));
        System.out.println("List of " + n + " abiturients with the highest average score:");
        for (int i = 0; i < n && i < sortedAbiturients.length; i++) {
            System.out.println(sortedAbiturients[i]);
        }

        float avgHalfPass = 2.4f;
        System.out.println("List of abiturients with average score > " + avgHalfPass + ":");
        for (Abiturient abiturient : abiturients) {
            if (abiturient.getAverageScore() > avgHalfPass) {
                System.out.println(abiturient);
            }
        }
    }
}
