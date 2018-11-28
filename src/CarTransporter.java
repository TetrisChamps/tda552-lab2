import java.awt.*;

/**
 * A higher order representation of an abstract truck.
 */
public class CarTransporter extends Car implements  ICarTransporter{
    private CarCarrier transporter = new CarCarrier(15, 2000);
    private Ramp ramp = new Ramp();

    /**
     * Initiates a Truck, based on subclass parameters
     *
     */
    public CarTransporter() {
        super(2, 437, Color.GRAY, "Car transporter AV", 0, 0, 10_000);
    }
    /**
     * Adds a car to the car trailer if the ramp is down.
     *
     * @param car
     */
    public void addCar(Car car) {
        if (ramp.isDown()) {
            transporter.addCar(car, this);
        }
    }

    /**
     * Removes a car from the car trailer if the ramp is down,
     * will return null if the ramp is down or if there are no cars
     * to be removed
     *
     * @return
     */

    public Car removeCar(){
        if (ramp.isDown()) {
            return transporter.removeCar(false, this);
        }
        return null;
    }

    /**
     * Lowers the ramp if the trailer is not moving.
     */
    public void raiseRamp() {
        ramp.raise();
    }

    /**
     * Highers the ramp, no cars can be added or removed.
     */
    public void lowerRamp() {
        ramp.lower();
    }

    @Override
    public double speedFactor() {
        return maxSpeed() * 0.01;
    }
}
