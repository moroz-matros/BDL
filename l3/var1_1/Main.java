package l3.var1_1;
/* 3. Определить класс Вектор в R3. Реализовать методы для проверки векторов
* на ортогональность, проверки пересечения не ортогональных векторов, сравнения векторов.
* Создать массив из m объектов. Определить, какие из векторов компланарны.
*/

public class Main {
    public static boolean areCoplanar(Vector[] vectors) {
        if (vectors.length < 3) {
            return true;
        }
        Vector v1 = vectors[0];
        Vector v2 = vectors[1];
        Vector normal = v1.crossProduct(v2).normalize();
        for (int i = 2; i < vectors.length; i++) {
            Vector v = vectors[i];
            if (normal.dotProduct(v.crossProduct(v1)) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Vector[] vectors1 = {
                new Vector(1, 0, 0),
                new Vector(0, 1, 0),
                new Vector(0, 0, 1),
                new Vector(1, 1, 1)
        };
        System.out.println("Coplanar: " + areCoplanar(vectors1));

        Vector[] vectors2 = {
                new Vector(1, -1, 2),
                new Vector(0, -1, 1),
                new Vector(2, -2, 4)
        };
        System.out.println("Coplanar: " + areCoplanar(vectors2));

        Vector v1 = new Vector(1, 2, 0);
        Vector v2 = new Vector(2, -1, 10);
        System.out.println("Orthogonal: " + v1.isOrthogonal(v2));

        v1 = new Vector(2, 4, 1);
        v2 = new Vector(3, 2, -8);
        System.out.println("Orthogonal: " + v1.isOrthogonal(v2));
        System.out.println("Intersects: " + v1.intersects(v2));

        v1 = new Vector(1, 2, 3);
        v2 = new Vector(2, 4, 6);
        System.out.println("Intersects: " + v1.intersects(v2));
        System.out.println("Longer: " + v1.isLonger(v2));
    }
}
