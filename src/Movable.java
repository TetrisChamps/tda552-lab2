public class Movable {
    private Vector position;
    private double rotation = 0.0;
    private double speed = 0.0;

    public Movable(double x, double y) {
        this.position = new Vector(x, y);
    }

    public void move() {
        position.x = Math.cos(Math.toRadians(rotation)) * speed;
        position.y = Math.sin(Math.toRadians(rotation)) * speed;
    }

    public void rotate(double angle) {
        this.rotation += angle;
    }

    public void increaseSpeed(double amount) {
        speed += amount;
    }

    public void decreaseSpeed(double amount) {
        speed -= Math.max(amount, 0);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }
}
