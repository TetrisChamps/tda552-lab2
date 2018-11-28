import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    private Vehicle vehicle;

    @BeforeEach
    void setUp() {
        vehicle = new Volvo240();
    }

    @AfterEach
    void tearDown() {
        vehicle = null;
    }

    @Test
    void applyDeltaToAngle() {
        assertEquals(300, Vehicle.applyDeltaToAngle(0, -60));
    }

    @Test
    void getModelName() {
        assertEquals("Volvo240", vehicle.getModelName());
    }

    @Test
    void getColor() {
        
    }

    @Test
    void move() {
    }

    @Test
    void speedFactor() {
    }

    @Test
    void gas() {
    }

    @Test
    void brake() {
    }

    @Test
    void maxSpeed() {
    }

    @Test
    void getSpeed() {
    }

    @Test
    void getRotation() {
    }

    @Test
    void rotateVehicle() {
    }

    @Test
    void getX() {
    }

    @Test
    void getY() {
    }

    @Test
    void setPosition() {
    }

    @Test
    void load() {
    }

    @Test
    void unload() {
    }

    @Test
    void isLoaded() {
    }

    @Test
    void getWeight() {
    }
}