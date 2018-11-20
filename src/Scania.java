import java.awt.*;

public class Scania extends Car {
    private int boardAngle = 0;

    public Scania() {
        super(2, 400, Color.RED, "Scania");
    }

    public void raiseBoard() {
        if (getCurrentSpeed() == 0){
            boardAngle += 5;
            boardAngle = Math.min(boardAngle, 70);
        }
    }

    public void lowerBoard() {
        if (getCurrentSpeed() == 0) {
            boardAngle -= 5;
            boardAngle = Math.max(boardAngle, 0);
        }
    }

    public int getBoardAngle() {
        return boardAngle;
    }

    @Override
    public void gas(double speed) {
        if (boardAngle == 0) {
            super.gas(speed);
        }
    }

    @Override
    public double speedFactor() {
        return 1;
    }
}
