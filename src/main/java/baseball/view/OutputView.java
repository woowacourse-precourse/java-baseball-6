package baseball.view;

public class OutputView {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL_FORMAT = "%d볼";
    private static final String STRIKE_FORMAT = "%d스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String SPACE = " ";
    private static final int ZERO = 0;

    public void printBallAndStrike(int ballCount, int strikeCount) {
        if (isZero(ballCount) && isZero(strikeCount)) {
            println(NOTHING);
            return;
        }
        if (isZero(strikeCount)) {
            println(getBallMessage(ballCount));
            return;
        }
        if (isZero(ballCount)) {
            println(getStrikeMessage(strikeCount));
            return;
        }
        println(getBallMessage(ballCount) + SPACE + getStrikeMessage(strikeCount));
    }

    private boolean isZero(int ballCount) {
        return ballCount == ZERO;
    }

    public void printGameStart() {
        println(GAME_START);
    }

    public void printGameEnd() {
        println(GAME_END);
    }

    private String getBallMessage(int ballCount) {
        return getFormattedMessage(BALL_FORMAT, ballCount);
    }

    private String getStrikeMessage(int strikeCount) {
        return getFormattedMessage(STRIKE_FORMAT, strikeCount);
    }

    private String getFormattedMessage(String format, Object... args) {
        return String.format(format, args);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
