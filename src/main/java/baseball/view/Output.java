package baseball.view;

public interface Output {

    void printStartMessage();

    void printEndMessage();

    void printRestartMessage();

    void printGameResult(int strikeCount, int ballCount);

}
