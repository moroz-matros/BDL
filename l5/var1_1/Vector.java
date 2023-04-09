package l5.var1_1;

public class Vector {
    private int x, y, z;

    public Vector(int x, int y, int z) {
        try {
            this.x = x;
            this.y = y;
            this.z = z;
        } catch (Exception e) {
            System.out.println("invalid args");
        }
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

    public Vector normalize() throws Exception {
        int mag = 0;
        try {
            mag = (int) magnitude();
            return new Vector((int) (x / mag), (int) (y / mag), (int) (z / mag));
        } catch (Exception e) {
            System.out.printf("%s\n", e.toString());
            throw e;
        }
    }

    // скалярное произведение
    public int dotProduct(Vector other) {
        return x * other.x + y * other.y + z * other.z;
    }

    // векторное произведение
    public Vector crossProduct(Vector other) {
        int cx = y * other.z - z * other.y;
        int cy = z * other.x - x * other.z;
        int cz = x * other.y - y * other.x;
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
        result = prime * result + x;
        result = prime * result + y;
        result = prime * result + z;
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
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        if (z != other.z)
            return false;
        return true;
    }

}
