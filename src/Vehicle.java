import java.awt.*;

public class Vehicle implements IMovable {
    private Color color; // Color of the car
    private final String modelName; // The car model name
    protected Movable movable;
    public Vehicle(Color color, String modelName, double x, double y) {
        this.color = color;
        this.modelName = modelName;
        this.movable = new Movable(x, y);
    }

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
