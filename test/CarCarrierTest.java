import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarCarrierTest {

    private CarCarrier carrier;

    @BeforeEach
    void setUp() {
        carrier = new CarCarrier(10, 2000);
    }

    @AfterEach
    void tearDown() {
        carrier = null;
    }

    @Test
    void move() {

    }

    @Test
    void addCar() {
    }

    @Test
    void removeCar() {
    }

    @Test
    void getCars() {
    }
}