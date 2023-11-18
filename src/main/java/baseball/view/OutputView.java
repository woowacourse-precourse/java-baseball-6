package baseball.view;

public class OutputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_FORMAT = "%d볼 ";
    private static final String STRIKE_FORMAT = "%d스트라이크";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";


    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static void printResult(boolean isNothing, int ballCount, int strikeCount) {
        if (isNothing) {
            printNothing();
            return;
        }
        printBallAndStrike(ballCount, strikeCount);
    }

    private static void printNothing() {
        System.out.println(NOTHING_MESSAGE);
    }

    private static void printBallAndStrike(int ballCount, int strikeCount) {
        StringBuilder resultMessage = new StringBuilder();
        if (ballCount != 0) {
            resultMessage.append(String.format(BALL_FORMAT, ballCount));
        }
        if (strikeCount != 0) {
            resultMessage.append(String.format(STRIKE_FORMAT, strikeCount));
        }
        System.out.println(resultMessage);
    }

    public static void printEnd() {
        System.out.println(END_MESSAGE);
    }
}
