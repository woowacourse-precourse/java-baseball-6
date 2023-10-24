package baseball.view;

public interface OutputView {

    void printStartMessage();

    void printGuessNumberInputMessage();

    void printGameResult(final int ballCount, final int strikeCount);

    void printWinningMessage();

    void printRestartOrEndMessage();
}
