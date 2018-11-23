public class Main {
    public static void main(String[] args) {
        Scania truck = new Scania();
        Scania truck2 = new Scania();
        CarTrailer t1 = new CarTrailer(7, 0, 0);
        CarTrailer t2 = new CarTrailer(15, 0, 0);
        Car c1 = new Saab95();
        Car c2 = new Volvo240();
        truck.attachTrailer(t1);
        truck.attachTrailer(t2);
        truck2.attachTrailer(t1);
    }
}
