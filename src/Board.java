public class Board {
    private int angle = 0; // The angle of the board, 0 = down

    /**
     * Raises the board
     */
    public void raise() {
        angle = Math.min(70, angle + 10);
    }

    /**
     * Lowers the board
     */
    public void lower() {
        angle = Math.max(0, angle - 10);
    }

    /**
     * Checks if the board is down
     *
     * @return
     */
    public boolean isDown() {
        return angle == 0;
    }

    /**
     * Returns the current angle of the board.
     *
     * @return the current angle of the board.
     */
    public int getAngle() {
        return angle;
    }
}
