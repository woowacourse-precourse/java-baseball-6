package baseball.view;

public interface Console {
    void printApplicationStartMessage();
    void printApplicationExitMessage();
    void printSelectMenuMessage();
    void printInputNumberMessage();
    String getUserInput();
    void printNumbersMatchResult(String matchResult);
    void printPlayerWinMessage();
}
