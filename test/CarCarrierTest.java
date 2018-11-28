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
        Car transporter = new Volvo240();
        assertEquals(null, carrier.removeCar(true, transporter));
        Car c = new Saab95();
        carrier.addCar(c, transporter);
        assertEquals(c, carrier.removeCar(false, transporter));
    }

    @Test
    void getCars() {
        assertEquals(carrier.getCars().size(), 0);
        Car transporter = new Volvo240();
        Car c1 = new Saab95();
        carrier.addCar(c1, transporter);
        Car c2 = new Saab95();
        carrier.addCar(c2, transporter);
        assertEquals(carrier.getCars().size(), 2);
    }
}