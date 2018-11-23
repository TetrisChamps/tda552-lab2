import java.awt.*;

public class CarFerry extends Vehicle implements ICarTransporter {

    private boolean inDock;
    private CarTransporter transporter;

    public CarFerry(Color color, String modelName, int capacity, double x, double y) {
        super(color, modelName, x, y);
        transporter = new CarTransporter(capacity);
    }


    @Override
    public void addCar(Car car) {
        if(inDock){
            transporter.addCar(car, movable);
        }
    }

    @Override
    public Car removeCar() {
        Car car;
        if(inDock){
            car = transporter.removeCar(true, movable);
        }
        return null;
    }

    public void dock() {
        if (movable.getSpeed() == 0) {
            inDock = true;
        }
    }

    public void unDock() {
        if (movable.getSpeed() == 0) {
            inDock = false;
        }
    }
}
