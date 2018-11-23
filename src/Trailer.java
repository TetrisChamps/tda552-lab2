/**
 * An abstract trailer that can be attached to a truck
 */
public abstract class Trailer implements IMovable {
    private Truck truck;
    protected Movable movable;

    /**
     * Creates a trailer at a position
     * @param x The start x coordinate
     * @param y The start y coordinate
     */
    public Trailer(double x, double y) {
        movable = new Movable(x, y);
    }

    /**
     * returns a reference to the truck that is attached to the trailer, can return null.
     * @return
     */

    public Truck getTruck() {
        return truck;
    }

    /**
     * Attaches truck to the trailer
     * @param truck Reference to the attached truck
     */
    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    /**
     * Movies the trailer
     */

    @Override
    public void move() {
        this.movable.move();
        //this.movable.setSpeed(truck.movable.getSpeed());
        //this.movable.setRotation(truck.movable.getRotation());
    }

    /**
     * Turns the truck to the left
     */
    @Override
    public void turnLeft() {
        this.movable.rotate(10);
    }

    /**
     * Turns the truck to the right
     */
    @Override
    public void turnRight() {
        this.movable.rotate(-10);
    }
}
