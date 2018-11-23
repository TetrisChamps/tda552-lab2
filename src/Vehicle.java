import java.awt.*;

/**
 * A representation of a high level vehicle.
 */
public abstract class Vehicle implements IMovable {
    private Color color; // Color of the vehicle
    private final String modelName; // The model name of the vehicle
    protected Movable movable; // The move behaviour of the vehicle

    public Vehicle(Color color, String modelName, double x, double y) {
        this.color = color;
        this.modelName = modelName;
        this.movable = new Movable(x, y);
    }

    /**
     * Returns the colour of the vehicle
     * @return
     */
    public Color getColor() {
        return color;
    }

    @Override
    public void move() {
        movable.move();
    }

    @Override
    public void turnLeft() {
        movable.rotate(10);
    }

    @Override
    public void turnRight() {
        movable.rotate(-10);
    }
}
