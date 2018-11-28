import java.awt.*;

/**
 * A representation of a Scania truck.
 */
public class Scania extends Car {
    private Ramp ramp = new Ramp();

    /**
     * Creates a normal Scania truck.
     */
    public Scania() {
        super(2, 400, Color.RED, "Scania");
    }

    /**
     * Raises the board of the truck, if the truck is not moving.
     */
    public void raiseBoard() {
        if (getSpeed() == 0) {
            ramp.raise();
        }
    }

    /**
     * Lowers the board of the truck, if the truck is not moving.
     */
    public void lowerBoard() {
        if (getSpeed() == 0) {
            ramp.lower();
        }
    }


    /**
     * Applies the gas if the board is in it's upright position.
     *
     * @param speed the speed which the truck is going to accelerate.
     */
    @Override
    public void gas(double speed) {
        if (!ramp.isDown()) {
            super.gas(speed);
        }
    }

    /**
     * The truck has a speed factor of 1.
     *
     * @return the speed factor of the truck.
     */
    @Override
    public double speedFactor() {
        return maxSpeed() * 0.01;
    }
}
