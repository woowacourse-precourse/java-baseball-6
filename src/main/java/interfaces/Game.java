package interfaces;

public interface Game {
    void init();

    String processTurn(String input) throws IllegalArgumentException;

    String toStringResult();

    boolean isValidInput();

    boolean isFinished();

    String getStartPrompt();

    String getFinishPrompt();

    String getPlayTurnPrompt();
}
