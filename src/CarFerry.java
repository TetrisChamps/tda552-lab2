import java.awt.*;

/**
 * A Ferry that transports cars
 */

public class CarFerry extends Vehicle implements ICarTransporter {

    private boolean inDock;
    private CarCarrier transporter;
    private double enginePower;

    /**
     * Initiates an instances of a CarFerry
     *
     * @param color     The colour of the ferry
     * @param modelName The modelname of the ferry
     * @param capacity  The number of cars the ferry and take
     * @param x         The start x coordinate of the ferry
     * @param y         The start y coordinate
     */
    public CarFerry(Color color, String modelName, int capacity, double x, double y, double enginePower) {
        super(color, modelName, x, y);
        this.enginePower = enginePower;
        transporter = new CarCarrier(capacity);
    }

    /**
     * Loads a car onto the ferry, if the car is already loaded it will throw an exception
     *
     * @param car The car to be loaded
     */
    @Override
    public void addCar(Car car) {
        if (inDock) {
            transporter.addCar(car, this);
        } else {
            throw new IllegalStateException("The ferry is not in a harbour");
        }
    }

    /**
     * Unloads a car from the ferry and returns a reference to the car, if the ferry is empty it will return null
     *
     * @return The unloaded car
     */

    @Override
    public Car removeCar() {
        Car car = null;
        if (inDock) {
            car = transporter.removeCar(true, this);
        }
        return car;
    }

    /**
     * Docks the ferry and enables it to load cars
     */
    public void dock() {
        if (getSpeed() == 0) {
            inDock = true;
        }
    }
    //TODO check if the ferry is close to a harbour


    /**
     * Undocks the ferry, disables the ability to load cars
     */
    public void unDock() {
        if (getSpeed() == 0) {
            inDock = false;
        }
    }

    @Override
    public double speedFactor() {
        return maxSpeed() * 0.01;
    }

    @Override
    public double maxSpeed() {
        return enginePower;
    }

    @Override
    public void turnLeft() {
        super.rotateVehicle(10);
    }

    @Override
    public void turnRight() {
        super.rotateVehicle(-10);
    }
}
