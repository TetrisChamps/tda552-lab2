import java.awt.*;

public abstract class Truck extends Car {

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


}
