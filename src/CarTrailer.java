import java.util.*;

public class CarTrailer extends Trailer {
    private boolean rampDown;
    private int capacity;

    private Stack<Car> cars = new Stack<>();

    public CarTrailer(Truck truck, int capacity) {
        super(truck);
        this.capacity = capacity;
    }

    public CarTrailer(int capacity) {
        this(null, capacity);
    }

    void lowerRamp() {
        if (getTruck() == null) {
            return;
        }
        if (getTruck().getCurrentSpeed() == 0) {
            rampDown = true;
        }
    }

    void liftRamp() {
        rampDown = false;
    }

    void addCar(Car car) {
        if (getTruck() == car) {
            return;
        }
        if(rampDown && cars.size() < capacity){
            if (cars.indexOf(car) < 0) {
                cars.push(car);
            }
        }
    }

    Car removeCar(){
        if(!cars.empty() && rampDown){
            //TODO: set car location near trailer
            return cars.pop();
        }
        return null;
    }
}
