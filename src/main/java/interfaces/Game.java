package interfaces;

public interface Game {
    void init();

    String playTurn(String input) throws IllegalArgumentException;

    String toStringResult();

    boolean isValidInput();

    boolean isFinished();
}
