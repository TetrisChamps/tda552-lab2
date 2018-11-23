public class Ramp extends Board {
    private boolean up = true;

    @Override
    public void raise() {
        up = true;
    }

    @Override
    public void lower() {
        up = false;
    }

    @Override
    public boolean isDown() {
        return !up;
    }
}
