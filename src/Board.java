public class Board {
    private int angle;

    public void raise() {
        angle = Math.min(70, angle + 10);
    }

    public void lower() {
        angle = Math.max(0, angle - 10);
    }

    public boolean isDown() {
        return angle == 0;
    }
}
