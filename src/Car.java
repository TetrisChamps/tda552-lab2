import java.awt.*;

/**
 * A wheeled motor-driven vehicle
 */
public abstract class Car extends Vehicle {
    //TODO: boolean to check if loaded
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private boolean engineOn = false;

    /**
     * Initiates a car, based on certain physical attributes.
     *
     * @param nrDoors     number of doors
     * @param enginePower The power of the engine
     * @param color       The color of the Car
     * @param modelName   The model of the car, the cars model.
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        super(color, modelName, 0, 0);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        stopEngine();
    }

    /**
     * Returns how many doors the car has
     * @return int
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Returns the engine power in terms of horse power.
     * @return double
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Returns the state of the engine, either on or off.
     * @return boolean
     */
    public boolean getEngineOn() {
        return engineOn;
    }

    /**
     * Turns on the engine
     */
    public void startEngine() {
        engineOn = true;
    }

    /**
     * Turns off the engine
     */
    public void stopEngine() {
        engineOn = false;
    }

    /**
     * Gives the highest maximum speed change
     *
     * @return Max speed change
     */
    public double speedFactor() {
        return 1.0;
    }

    /**
     * Increases the speed of the car
     * @param amount
     */
    private void increaseSpeed(double amount) {
        if (engineOn) {
            movable.increaseSpeed(speedFactor() * amount);
            if (movable.getSpeed() > getEnginePower()) {
                movable.setSpeed(getEnginePower());
            }
        }
    }

    /**
     * Decreases the speed of the car.
     * @param amount
     */
    private void decreaseSpeed(double amount) {
        movable.decreaseSpeed(speedFactor() * amount);
    }

    /**
     * Applies the throttle between 0-1
     *
     * @param amount
     */
    public void gas(double amount) {
        increaseSpeed(Maths.clamp(amount, 0.0, 1.0));
    }

    /**
     * Presses down the brake by a factor of 0-1
     *
     * @param amount
     */
    public void brake(double amount) {
        decreaseSpeed(Maths.clamp(amount, 0.0, 1.0));
    }
}
