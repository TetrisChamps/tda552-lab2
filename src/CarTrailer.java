import java.util.Stack;

public class CarTrailer extends Trailer {
    private boolean rampDown;
    private int capacity;

    private Stack<Car> cars = new Stack<>();

    public CarTrailer(int capacity, double x, double y) {
        super(x, y);
        this.capacity = capacity;
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

    /**
     * Adds a car to the trailer if there is still enough room left and the ramp is down.
     *
     * @param car
     */
    public void addCar(Car car) {
        if (getTruck() == car) {
            return;
        }
        if (rampDown && cars.size() < capacity) {
            if (cars.indexOf(car) < 0) {
                cars.push(car);
                car.stopEngine();
                // Vi skulle kunna uppdatera bilarnas positioner genom att överskugga move-metoden
                car.movable.setPosition(this.movable.getPosition());
            }
        }
    }

    /**
     * Removes the last car added (last in first out) to the trailer, if the ramp is down.
     * If there are no cars on the trailer null is returned.
     *
     * @return Car removedCar
     */
    public Car removeCar() {
        if (!cars.empty() && rampDown) {
            Car car = cars.pop();
            car.movable.setPosition(new Vector(this.movable.getPosition().x, this.movable.getPosition().y + 1));
            return car;
        }
        return null;
    }
}
