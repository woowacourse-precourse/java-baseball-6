package interfaces;

public interface Game {
    void init();

    String playTurn(String input);

    void validateGameInput(String input) throws IllegalArgumentException;

    boolean isFinished();

    String getStartPrompt();

    String getFinishPrompt();

    String getPlayTurnPrompt();
}
