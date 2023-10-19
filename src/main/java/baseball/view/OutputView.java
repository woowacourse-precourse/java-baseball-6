package baseball.view;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String BALL_FORMAT = "%d볼";
    private static final String STRIKE_FORMAT = "%d스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String SPACE = " ";
    private static final int ZERO = 0;

    public void printBallAndStrike(int ballCount, int strikeCount) {
        if (ballCount == ZERO && strikeCount == ZERO) {
            println(NOTHING);
            return;
        }
        if (strikeCount == ZERO) {
            println(formattedBall(ballCount));
            return;
        }
        if (ballCount == ZERO) {
            println(formattedStrike(strikeCount));
            return;
        }
        println(formattedBall(ballCount) + SPACE + formattedStrike(strikeCount));
    }

    public void printGameStart() {
        println(GAME_START_MESSAGE);
    }

    private String formattedBall(int ballCount) {
        return String.format(BALL_FORMAT, ballCount);
    }

    private String formattedStrike(int strikeCount) {
        return String.format(STRIKE_FORMAT, strikeCount);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
