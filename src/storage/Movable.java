package storage;

import storage.Vector;

/**
 * Represents the behaviour of an object that can be moved around in a 2D world.
 */
public class Movable {
    private Vector position; // The position of the object
    private double rotation = 0.0; // The rotation of the object, in degrees
    private double speed = 0.0; // The speed of the object

    public Movable(double x, double y) {
        this.position = new Vector(x, y);
    }

    /**
     * Moves the car a distance of its current speed in the direction it is facing
     */
    public void move() {
        position.x = Math.cos(Math.toRadians(rotation)) * speed;
        position.y = Math.sin(Math.toRadians(rotation)) * speed;
    }

    /**
     * Rotates the object by a angle (in degrees)
     * @param angle
     */
    public void rotate(double angle) {
        this.rotation += angle;
    }

    /**
     * Increases the speed by amount
     * @param amount
     */
    public void increaseSpeed(double amount) {
        speed += amount;
    }

    /**
     * Decreses the speed by amount
     * @param amount
     */
    public void decreaseSpeed(double amount) {
        speed -= Math.max(amount, 0);
    }

    /**
     * Returns the speed of the object
     * @return
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets the speed of the object
     * @param speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Vector getPosition() {
        return position;
    }

    /**
     * Sets the position of the object
     * @param position
     */
    public void setPosition(Vector position) {
        this.position = position;
    }
}
