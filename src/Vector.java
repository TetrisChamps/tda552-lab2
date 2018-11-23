/**
 * A mathematical representation of a two dimensional vector.
 */
public class Vector {
    public double x;
    public double y;

    /**
     * Creates a new vector based on x, y parameters
     * @param x the x component.
     * @param y the y component.
     */
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a vector with a magnitude 0.
     */
    public Vector() {
        this(0.0, 0.0);
    }

    /**
     * Clones an existing vector.
     * @param v the existing vector
     */
    public Vector(Vector v) {
        this(v.x, v.y);
    }

    /**
     * Adds two vectors.
     * @param v the other vector.
     */
    public void add(Vector v) {
        this.x = v.x;
        this.y = v.y;
    }

    /**
     * Multiplies two vectors.
     * @param d the scalar.
     */
    public void mult(double d) {
        this.x *= d;
        this.y *= d;
    }

    /**
     * Divides two vectors
     * @param d scalar.
     */
    public void div(double d) {
        this.x /= d;
        this.y /= d;
    }

    /**
     * Gets the magnitude(length) of the vector.
     * @return returns the magnitude of the vector.
     */
    public double magnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    /**
     * Gets the rotation of the vector.
     * @return the angle.
     */
    public double rotation() {
        if (magnitude() == 0.0) {
            throw new IllegalArgumentException("Cannot rotate a vector with magnitude 0");
        }
        return Math.acos(x / magnitude());
    }

    /**
     * Rotates a vector
     * @param angle the angle to rotate with.
     */
    public void rotate(int angle) {
        double rotation = rotation();
        rotation += angle;
        this.x = Math.cos(angle) * magnitude();
        this.y = Math.sin(angle) * magnitude();
    }
}
