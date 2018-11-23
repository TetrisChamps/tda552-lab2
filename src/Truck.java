import java.awt.*;

/**
 * A higher order representation of an abstract truck.
 */
public abstract class Truck extends Car {

    private Trailer trailer;

    /**
     * Initiates a Truck, based on subclass parameters
     *
     * @param nrDoors     number of doors
     * @param enginePower The power of the engine
     * @param color       The color of the Truck
     * @param modelName   The model of the Truck, the trucks model.
     */
    public Truck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    /**
     * Binds a trailer to the truck
     * @param trailer the trailer to be attached.
     */
    public void attachTrailer(Trailer trailer) {
        // Check if the truck already has a truck attached.
        if (this.trailer != null && trailer.getTruck() != this) {
            throw new IllegalStateException("Truck already has a trailer attached!");
        }
        // Check if the trailer is attached to another truck.
        if (trailer.getTruck() != null && trailer.getTruck() != this) {
            throw new IllegalStateException("Trailer is already attached to another truck");
        }

        this.trailer = trailer;
        this.trailer.setTruck(this);
    }

    /**
     * Detaches the attached trailer, if the trailer exists.
     * @return the detached trailer.
     */
    public Trailer detachTrailer() {
        if (this.trailer == null) {
            throw new IllegalStateException("Cannot detach non-existing trailer!");
        }
        Trailer out = this.trailer;
        this.trailer.setTruck(null);
        this.trailer = null;
        return out;
    }

    @Override
    public void move() {
        super.move();
        if (trailer != null) {
            trailer.move();
        }
    }

    @Override
    public void turnLeft() {
        super.turnLeft();
        if (trailer != null) {
            trailer.turnLeft();
        }
    }

    @Override
    public void turnRight() {
        super.turnRight();
        if (trailer != null) {
            trailer.turnLeft();
        }
    }

    @Override
    public void gas(double amount) {
        super.gas(amount);
        if (trailer != null) {
            trailer.movable.setSpeed(this.movable.getSpeed());
        }
    }
}
