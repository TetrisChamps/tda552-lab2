public class Main {
    public static void main(String[] args) {
        Scania truck = new Scania();
        Scania truck2 = new Scania();
        CarTransporter t = new CarTransporter();
        Car c1 = new Saab95();
        Car c2 = new Volvo240();
        t.addCar(c1);
        Car c3 = t.removeCar();

    }
}
