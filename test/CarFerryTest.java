import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarFerryTest {

    CarFerry carFerry;

    @BeforeEach
    void setUp() {
        carFerry = new CarFerry(0, 0);
    }

    @AfterEach
    void tearDown() {
        carFerry = null;
    }

    @Test
    void addCar() {
        Car car = new Saab95();
        carFerry.addCar(car);

        carFerry.dock();
        assertEquals(carFerry.getCars().size(), 1);

        carFerry.unDock();
        Car car1 = new Volvo240();

        carFerry.addCar(car1);
        assertEquals(carFerry.getCars().size(), 1);

    }

    @Test
    void removeCar() {
    }

    @Test
    void dock() {
    }

    @Test
    void unDock() {
    }
}