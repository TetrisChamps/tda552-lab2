public class Board {
    private int angle = 0;

    public void raise() {
        angle = Math.min(70, angle + 10);
    }

    public void lower() {
        angle = Math.max(0, angle - 10);
    }

    public boolean isDown() {
        return angle == 0;
    }

    /**
     * Returns the current angle of the board.
     * @return the current angle of the board.
     */
    public int getAngle() {
        return angle;
    }
}
