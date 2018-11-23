public class Trailer implements IMovable {
    private Truck truck;
    protected Movable movable;

    public Trailer(double x, double y) {
        movable = new Movable(x, y);
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    @Override
    public void move() {
        this.movable.move();
        //this.movable.setSpeed(truck.movable.getSpeed());
        //this.movable.setRotation(truck.movable.getRotation());
    }

    @Override
    public void turnLeft() {
        this.movable.rotate(10);
    }

    @Override
    public void turnRight() {
        this.movable.rotate(-10);
    }
}
