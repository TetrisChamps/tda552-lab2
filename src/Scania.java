import java.awt.*;

/**
 * A representation of a Scania truck.
 */
public class Scania extends Car {
    private int boardAngle = 0;

    /**
     * Creates a normal Scania truck.
     */
    public Scania() {
        super(2, 400, Color.RED, "Scania");
    }

    /**
     * Raises the board of the truck, if the truck is not moving.
     */
    public void raiseBoard() {
        if (this.movable.getSpeed() == 0){
            boardAngle += 5;
            // Limits the board to a maximum angle of 70.
            boardAngle = Math.min(boardAngle, 70);
        }
    }

    /**
     *  Lowers the board of the truck, if the truck is not moving.
     */
    public void lowerBoard() {
        if (this.movable.getSpeed() == 0) {
            boardAngle -= 5;
            boardAngle = Math.max(boardAngle, 0);
        }
    }

    /**
     * Get the current angle of the board.
     *
     * @return The current angle of the board.
     */
    public int getBoardAngle() {
        return boardAngle;
    }

    /**
     * Applies the gas if the board is in it's upright position.
     * @param speed the speed which the truck is going to accelerate.
     */
    @Override
    public void gas(double speed) {
        if (boardAngle == 0) {
            super.gas(speed);
        }
    }

    /**
     * The truck has a speed factor of 1.
     * @return the speed factor of the truck.
     */
    @Override
    public double speedFactor() {
        return 1;
    }
}
