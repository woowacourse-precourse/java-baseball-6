package baseball.printer;

public class ConsoleGamePrinter implements GamePrinter {
    private static final String SPACE = " ";

    @Override
    public void greet() {
        System.out.println(PrintMessage.GREET.getMessage());
    }

    @Override
    public void requestInputGameNumber() {
        System.out.print(PrintMessage.REQUEST_INPUT_GAME_NUMBER.getMessage());
    }

    @Override
    public void printBallCount(String ballCount) {
        System.out.println(ballCount + PrintMessage.BALL.getMessage());
    }

    @Override
    public void printStrikeCount(String strikeCount) {
        System.out.println(strikeCount + PrintMessage.STRIKE.getMessage());
    }

    @Override
    public void printBallAndStrikeCount(String strikeCount, String ballCount) {
        System.out.println(ballCount + PrintMessage.BALL.getMessage() + SPACE + strikeCount
                + PrintMessage.STRIKE.getMessage());
    }

    @Override
    public void printNothing() {
        System.out.println(PrintMessage.NOTHING.getMessage());
    }

    @Override
    public void noticeWin() {
        System.out.println(PrintMessage.NOTICE_WIN.getMessage());
    }

    @Override
    public void requestInputRestartNumber() {
        System.out.println(PrintMessage.REQUEST_INPUT_RESTART_NUMBER.getMessage());
    }
}
