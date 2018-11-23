import java.util.Stack;

public class CarTrailer extends Trailer implements ICarTransporter {
    private boolean rampDown;
    private CarTransporter transporter;

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
        if (getTruck() == null) {
            return;
        }
        if (getTruck().movable.getSpeed() == 0) {
            rampDown = true;
        }
    }

    /**
     * Highers the ramp, no cars can be added or removed.
     */
    public void liftRamp() {
        rampDown = false;
    }

    public void addCar(Car car) {
        if (rampDown) {
            transporter.addCar(car, movable);
        }
    }

    public Car removeCar() {
        if (rampDown) {
            return transporter.removeCar(false, movable);
        }
        return null;
    }
}
