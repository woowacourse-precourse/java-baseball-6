package baseball;

public abstract class Input {
    public abstract void readInput();

    protected void throwIllegalArgumentException() {
        throw new IllegalArgumentException();
    }
}
