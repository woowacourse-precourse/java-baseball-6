package baseball.view;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String EMPTY_MESSAGE = "";
    private static final int ZERO = 0;

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }

    public void printResult(int ball, int strike) {
        System.out.println(generateResultMessage(ball, strike));
    }

    private String generateResultMessage(int ball, int strike) {
        if (isNothing(ball, strike)) {
            return NOTHING_MESSAGE;
        }
        return generateMessageOf(ball, strike).trim();
    }

    private boolean isNothing(int ball, int strike) {
        return ball == ZERO && strike == ZERO;
    }

    private String generateMessageOf(int ball, int strike) {
        return String.format("%s %s", generateMessage(ball, BALL_MESSAGE), generateMessage(strike, STRIKE_MESSAGE));
    }

    private String generateMessage(int count, String suffix) {
        if (count == ZERO) {
            return EMPTY_MESSAGE;
        }
        return count + suffix;
    }
}
