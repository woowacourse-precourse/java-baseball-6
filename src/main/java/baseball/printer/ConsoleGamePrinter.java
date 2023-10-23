package baseball.printer;

public class ConsoleGamePrinter implements GamePrinter {
    private static final String SPACE = " ";

    @Override
    public void greet() {
        System.out.println(PrintMessage.GREET);
    }

    @Override
    public void requestInputGameNumber() {
        System.out.println(PrintMessage.REQUEST_INPUT_GAME_NUMBER);
    }

    @Override
    public void printBallCount(String ballCount) {
        System.out.println(ballCount + PrintMessage.BALL);
    }

    @Override
    public void printStrikeCount(String strikeCount) {
        System.out.println(strikeCount + PrintMessage.STRIKE);
    }

    @Override
    public void printBallAndStrikeCount(String strikeCount, String ballCount) {
        System.out.println(ballCount + PrintMessage.BALL + SPACE + PrintMessage.STRIKE);
    }

    @Override
    public void printNothing() {
        System.out.println(PrintMessage.NOTHING);
    }

    @Override
    public void noticeWin() {
        System.out.println(PrintMessage.NOTICE_WIN);
    }

    @Override
    public void requestInputRestartNumber() {
        System.out.println(PrintMessage.REQUEST_INPUT_RESTART_NUMBER);
    }
}
