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
            return mag1 >= mag2;
        } else {
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

    public boolean intersects(Vector other) {
        return !((crossProduct(other).equals(new Vector(0, 0, 0)) &&
                !this.equals(other)));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vector other = (Vector) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
            return false;
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
            return false;
        if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
            return false;
        return true;
    }
}
