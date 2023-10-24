package baseball.game;

public interface Game {
    void playGame();
    Printer getPrinter();
    Validator getValidator();
    Config getConfig();
}
