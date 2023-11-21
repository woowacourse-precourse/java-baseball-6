package baseball.view;

public class OutputView {
    public static OutputView instance = new OutputView();
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_FORMAT = "%d볼 ";
    private static final String STRIKE_FORMAT = "%d스트라이크";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final int NO_COUNT = 0;

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printResult(boolean isNothing, int ballCount, int strikeCount) {
        if (isNothing) {
            printNothing();
            return;
        }
        printBallAndStrike(ballCount, strikeCount);
    }

    private void printNothing() {
        System.out.println(NOTHING_MESSAGE);
    }

    private void printBallAndStrike(int ballCount, int strikeCount) {
        StringBuilder resultMessage = new StringBuilder();
        if (ballCount != NO_COUNT) {
            resultMessage.append(String.format(BALL_FORMAT, ballCount));
        }
        if (strikeCount != NO_COUNT) {
            resultMessage.append(String.format(STRIKE_FORMAT, strikeCount));
        }
        System.out.println(resultMessage);
    }

    public void printEnd() {
        System.out.println(END_MESSAGE);
    }
}
