package interfaces;

public interface Game {
    void init();

    String processTurn(String input);

    String gameResultToString();

    void validateGameInput(String input) throws IllegalArgumentException;

    boolean isFinished();

    String getStartPrompt();

    String getFinishPrompt();

    String getPlayTurnPrompt();
}
