public class Vector {
    public double x;
    public double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector() {
        this(0.0, 0.0);
    }

    public Vector(Vector v) {
        this(v.x, v.y);
    }

    public void add(Vector v) {
        this.x = v.x;
        this.y = v.y;
    }

    public void mult(double d) {
        this.x *= d;
        this.y *= d;
    }

    public void div(double d) {
        this.x /= d;
        this.y /= d;
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public double rotation() {
        if (magnitude() == 0.0) {
            throw new IllegalArgumentException("Cannot rotate a vector with magnitude 0");
        }
        return Math.acos(x / magnitude());
    }

    public void rotate(int angle) {
        double rotation = rotation();
        rotation += angle;
        this.x = Math.cos(angle) * magnitude();
        this.y = Math.sin(angle) * magnitude();
    }
}
