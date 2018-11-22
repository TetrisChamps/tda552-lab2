import java.awt.*;

/**
 * A representation of an abstract car that is movable.
 */
public abstract class Car extends Vehicle {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private boolean engineOn = false;

    /**
     * Initiates a car, based on subclass parameters
     *
     * @param nrDoors     number of doors
     * @param enginePower The power of the engine
     * @param color       The color of the Car
     * @param modelName   The model of the car, the cars model.
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        super(color, modelName);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        stopEngine();
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

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
    private void stopEngine() {
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

    private void increaseSpeed(double amount) {
        if (engineOn) {
            movable.increaseSpeed(speedFactor() * amount);
            super.increaseSpeed(speedFactor() * amount);
            if (getSpeed() > getEnginePower()) {
                super.decreaseSpeed(getSpeed() - getEnginePower());
            }
        }
    }

    private void decreaseSpeed(double amount) {
        movable.decreaseSpeed(speedFactor() * amount);
        super.decreaseSpeed(speedFactor() * amount);
    }

    /**
     * Applies the throttle between 0-1
     *
     * @param speed
     */
    public void gas(double speed) {
        increaseSpeed(Maths.clamp(speed, 0.0, 1.0));
    }

    /**
     * Presses down the break lever machine stick by a factor of 0-1
     *
     * @param
     */
    public void brake(double speed) {
        decreaseSpeed(Maths.clamp(speed, 0.0, 1.0));
    }
}
