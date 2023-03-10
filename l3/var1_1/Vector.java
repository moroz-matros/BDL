package l3.var1_1;

public class Vector {
    private double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public boolean isLonger(Vector v) {
        Vector crossProduct = this.crossProduct(v);
        double mag1 = this.magnitude();
        double mag2 = v.magnitude();
        double magCross = crossProduct.magnitude();
        if (magCross == 0) {
            // vectors are parallel, return the longer one
            return mag1 >= mag2;
        } else {
            // vectors are not parallel, return the one with the largest cross product
            double angle = Math.asin(magCross / (mag1 * mag2));
            return mag1 * Math.sin(angle) >= mag2 * Math.sin(angle);
        }
    }

    public Vector normalize() {
        double mag = magnitude();
        return new Vector(x / mag, y / mag, z / mag);
    }

    // скалярное произведение
    public double dotProduct(Vector other) {
        return x * other.x + y * other.y + z * other.z;
    }

    // векторное произведение
    public Vector crossProduct(Vector other) {
        double cx = y * other.z - z * other.y;
        double cy = z * other.x - x * other.z;
        double cz = x * other.y - y * other.x;
        return new Vector(cx, cy, cz);
    }

    public boolean isOrthogonal(Vector other) {
        return dotProduct(other) == 0;
    }

    public boolean equals(Vector other) {
        return x == other.x && y == other.y && z == other.z;
    }

    public boolean intersects(Vector other) {
        return !((crossProduct(other).equals(new Vector(0, 0, 0)) &&
                !this.equals(other)));
    }
}
