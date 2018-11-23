import java.awt.*;

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


    public void attatchTrailer(Trailer trailer) {
        if (this.trailer != null && trailer.getTruck() != this) {
            throw new IllegalStateException("Truck already has a trailer attached!");
        }
        if (trailer.getTruck() != null && trailer.getTruck() != this) {
            throw new IllegalStateException("Trailer is already attached to another truck");
        }
        this.trailer = trailer;
        this.trailer.setTruck(this);
    }

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

    public void turnRight() {
        super.turnRight();
        if (trailer != null) {
            trailer.turnLeft();
        }
    }

    public void gas(double amount) {
        super.gas(amount);
        if (trailer != null) {
            trailer.movable.setSpeed(this.movable.getSpeed());
        }
    }
    //TODO: Make cars on trailer not able to gas.
}
