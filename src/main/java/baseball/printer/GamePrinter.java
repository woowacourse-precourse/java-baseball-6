package baseball.printer;

public interface GamePrinter {
    void greet();

    void requestInputGameNumber();

    void printBallCount(String ballCount);

    void printStrikeCount(String strikeCount);

    void printBallAndStrikeCount(String strikeCount, String ballCount);

    void printNothing();

    void noticeWin();

    void requestInputRestartNumber();
}
