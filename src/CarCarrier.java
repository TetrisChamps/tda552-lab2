import java.util.LinkedList;

/**
 * A class that can hold cars.
 */
public class CarCarrier {
    LinkedList<Car> cars = new LinkedList<>();
    private int capacity;

    /**
     *  Creates the CarCarrier object.
     * @param capacity The amount of cars that the ferry can hold.
     */
    public CarCarrier(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Adds a car to the trailer if there is still enough room left and the ramp is down.
     * @param car The car to be added.
     * @param movable The Movable object from the carrier.
     */
    public void addCar(Car car, Vehicle vehicle) {
        if (vehicle == car) {
            throw new IllegalArgumentException("Cannot add itself to the transport carrier");
        }
        if (cars.size() < capacity) {
            if (!cars.contains(car)) {
                cars.addLast(car);
                car.stopEngine();
                // Vi skulle kunna uppdatera bilarnas positioner genom att överskugga move-metoden
                car.movable.setPosition(vehicle.movable.getPosition());
                return;
            }
            throw new IllegalStateException("Cannot add a car that is already being transported!");
        }
    }

    /**
     * Removes the car specified by the first parameter. If the first parameter is true,
     * then the first car in gets removed first, and if the first parameter is false, the
     * last car in gets removed first.
     * The removed car is set to the position of the carrier + 1 on the y axis.
     * If there are no cars on the trailer null is returned.
     * @param first Specifies whether the first or last car in gets removed first
     * @param movable The movable object of the carrier.
     * @return the removed car.
     */
    public Car removeCar(boolean first, Vehicle vehicle) {
        if (cars.size() > 0) {
            Car car;
            if (first) {
                car = cars.removeFirst();
            } else {
                car = cars.removeLast();
            }
            car.movable.setPosition(new Vector(vehicle.movable.getPosition().x, vehicle.movable.getPosition().y + 1));
            return car;
        }
        return null;
    }
}
