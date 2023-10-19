package baseball.view;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String EMPTY = "";
    private static final int ZERO = 0;

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }

    public void printResult(int ball, int strike) {
        String resultMessage = generateResultMessage(ball, strike).trim();

        System.out.println(resultMessage);
    }

    private String generateResultMessage(int ball, int strike) {
        if (isNothing(ball, strike)) {
            return NOTHING;
        }
        return String.format("%s %s", generateBallMessage(ball), generateStrikeMessage(strike));
    }

    private boolean isNothing(int ball, int strike) {
        return ball == ZERO && strike == ZERO;
    }

    private String generateBallMessage(int ball) {
        if (ball == ZERO) {
            return EMPTY;
        }
        return ball + BALL;
    }

    private String generateStrikeMessage(int strike) {
        if (strike == ZERO) {
            return EMPTY;
        }
        return strike + STRIKE;
    }
}
