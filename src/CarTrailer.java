import java.util.Stack;

/**
 * A trailer that carries cars.
 */
public class CarTrailer extends Trailer implements ICarTransporter {
    private boolean rampDown; // Holds the state of the ramp
    private CarTransporter transporter; // The car transportation behaviour

    public CarTrailer(int capacity, double x, double y) {
        super(x, y);
        this.transporter = new CarTransporter(capacity);
    }

    public CarTrailer(int capacity) {
        this(capacity, 0, 0);
    }

    /**
     * Lowers the ramp if the trailer is not moving.
     */
    public void lowerRamp() {
        if (movable.getSpeed() == 0) {
            rampDown = true;
        }
    }

    /**
     * Highers the ramp, no cars can be added or removed.
     */
    public void liftRamp() {
        rampDown = false;
    }

    /**
     * Adds a car to the car trailer if the ramp is down.
     * @param car
     */
    public void addCar(Car car) {
        if (rampDown) {
            transporter.addCar(car, movable);
        }
    }

    /**
     * Removes a car from the car trailer if the ramp is down
     * @return
     */
    public Car removeCar() {
        if (rampDown) {
            return transporter.removeCar(false, movable);
        }
        return null;
    }
}
