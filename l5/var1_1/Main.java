package l5.var1_1;

// Выполнить задания на основе варианта 1 лабораторной работы 3,
// контролируя состояние потоков ввода/вывода. При возникновении ошибок,
// связанных с корректностью выполнения математических операций, генерировать и
// обрабатывать исключительные ситуации. Предусмотреть обработку исключений,
// возникающих при нехватке памяти, отсутствии требуемой записи (объекта) в файле,
// недопустимом значении поля и т.д.

public class Main {
    public static boolean areCoplanar(Vector[] vectors) {
        if (vectors.length < 3) {
            return true;
        }
        Vector v1, v2;
        try {
            v1 = vectors[0];
            v2 = vectors[1];
        } catch (Exception e) {
            System.out.println("out of range");
            return false;
        }

        Vector normal;
        try {
            normal = v1.crossProduct(v2).normalize();
        } catch (Exception e) {
            return false;
        }

        for (int i = 2; i < vectors.length; i++) {
            Vector v = vectors[i];
            if (normal.dotProduct(v.crossProduct(v1)) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Vector v1 = new Vector(0, 0, 0);
        try {
            v1.normalize();
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
