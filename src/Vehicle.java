import java.awt.*;

/**
 * A representation of a high level vehicle.
 */
public abstract class Vehicle implements IMovable {
    private Color color; // Color of the vehicle

    public String getModelName() {
        return modelName;
    }

    private final String modelName; // The model name of the vehicle
    private double x;
    private double y;
    private double rotation = 0.0; // The rotation of the object, in degrees
    private double speed = 0.0; // The speed of the object


    /**
     * Standard constructor for making an abstract vehicle, must be called from subclass
     * @param color
     * @param modelName
     * @param x Coordinate x
     * @param y Coordinate y
     */
    public Vehicle(Color color, String modelName, double x, double y) {
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
    }

    /**
     * Adds an angle to another and returns the new angle based on the unit circle
     * @param angle Base angle
     * @param deltaAngle Angle to be added to the base
     * @return The resulting angle
     */

    public static double applyDeltaToAngle(double angle, double deltaAngle) {
        angle = (angle + deltaAngle) % 360;
        return (angle > 0) ? angle : 360 + angle;

    }

    /**
     * Returns the colour of the vehicle
     *
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     * Moves the car a distance of its current speed in the direction it is facing
     */
    @Override
    public void move() {
        x = Math.cos(Math.toRadians(rotation)) * speed;
        y = Math.sin(Math.toRadians(rotation)) * speed;
    }


    /**
     * Returns the maximum acceleration of the Vehicle.
     *
     * @return The increase in speed.
     */
    public abstract double speedFactor();

    private void increaseSpeed(double amount) {
        double newSpeed = speed + speedFactor() * amount;
        speed = maxSpeed() >= newSpeed ? newSpeed : maxSpeed();
    }

    private void decreaseSpeed(double amount) {
        double newSpeed = speed - speedFactor() * amount;
        speed = newSpeed > 0 ? newSpeed : 0;
    }

    /**
     * Increases the current speed, must be called from overridden subclasses
     *
     * @return
     */


    public void gas(double amount) {
        increaseSpeed(Maths.clamp(amount, 0.0, 1.0));
    }

    /**
     * Decreases the speed of the vehicle, must be called from overriden methods.
     * @param amount
     */

    public void brake(double amount) {
        decreaseSpeed(amount);
    }

    /**
     * This abstract method returns the maximum speed of an object in any direction. This must be overriden as
     * how a vehicle defines its maximum speed can vary greatly.
     * @return maxSpeed
     */

    public abstract double maxSpeed();

    /**
     * Returns the current speed of the vehicle
     *
     * @return Current speed
     */

    public double getSpeed() {
        return speed;
    }

    /**
     * Returns the rotation of the vehicle
     * @return Current rotation
     */

    public double getRotation() {
        return rotation;
    }

    /**
     * Sets the rotation of the object in degrees
     */
    public final void rotateVehicle(double deltaAngle) {
        this.rotation = applyDeltaToAngle(this.rotation, deltaAngle);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Sets the x and y coordinates.
     * @param
     */

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;

    }
}
