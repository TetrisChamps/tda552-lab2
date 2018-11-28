/**
 * A class representing a board, that can be raised and lowered.
 */
public class Board {

    private int angle;

    /**
     * Raises the board by 10 degrees
     */
    public void raise() {
        angle = Math.min(70, angle + 10);
    }

    /**
     * Lowers the car by 10 degrees
     */
    public void lower() {
        angle = Math.max(0, angle - 10);
    }

    /**
     * If the board is fully raised, returns true, else false.
     * @return
     */
    public boolean isDown() {
        return angle == 0;
    }
}
