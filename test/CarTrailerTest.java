import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTrailerTest {
    Scania scania;
    CarTrailer trailer;
    Car car;
    @BeforeEach
    void setUp() {
        scania = new Scania();
        trailer = new CarTrailer(2);
        car = new Saab95();
    }

    @AfterEach
    void tearDown() {
        scania = null;
        trailer = null;
        car = null;
    }

    @Test
    void lowerRamp() {
        
    }

    @Test
    void liftRamp() {
    }

    @Test
    void addCar() {
    }

    @Test
    void removeCar() {
    }
}