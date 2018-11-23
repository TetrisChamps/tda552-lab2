import java.util.LinkedList;

public class CarTransporter {
    LinkedList<Car> cars = new LinkedList<>();
    private int capacity;

    public CarTransporter(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Adds a car to the trailer if there is still enough room left and the ramp is down.
     *
     * @param car
     */
    public void addCar(Car car, Movable movable) {
        if (cars.size() < capacity) {
            if (cars.contains(car)) {
                cars.addLast(car);
                car.stopEngine();
                // Vi skulle kunna uppdatera bilarnas positioner genom att överskugga move-metoden
                car.movable.setPosition(movable.getPosition());
            }
        }
    }

    /**
     * Removes the last car added (last in first out) to the trailer, if the ramp is down.
     * If there are no cars on the trailer null is returned.
     *
     * @return Car removedCar
     */
    public Car removeCar(boolean first, Movable movable) {
        if (cars.size() > 0) {
            Car car;
            if (first) {
                car = cars.removeFirst();
            } else {
                car = cars.removeLast();
            }
            car.movable.setPosition(new Vector(movable.getPosition().x, movable.getPosition().y + 1));
            return car;
        }
        return null;
    }
}
