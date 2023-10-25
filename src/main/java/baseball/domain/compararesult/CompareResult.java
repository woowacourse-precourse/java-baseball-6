package baseball.domain.compararesult;

public class CompareResult {

    private static final int INITIAL_COUNT = 0;
    private static final int ANSWER_STRIKE_COUNT = 3;
    private static final String STRIKE_MESSAGE_FORMAT = "%d스트라이크";
    private static final String BALL_MESSAGE_FORMAT = "%d볼";
    private static final String NOTHING_MESSAGE = "낫싱";

    private int strike = INITIAL_COUNT;
    private int ball = INITIAL_COUNT;

    public void addStrike() {
        strike += 1;
    }

    public void addBall() {
        ball += 1;
    }

    public boolean isAnswer() {
        return strike == ANSWER_STRIKE_COUNT;
    }

    @Override
    public String toString() {
        if (strike == INITIAL_COUNT && ball == INITIAL_COUNT) {
            return NOTHING_MESSAGE;
        }
        StringBuilder stringBuilder = new StringBuilder();
        addBallMessage(stringBuilder);
        addSpaceBetween(stringBuilder);
        addStrikeMessage(stringBuilder);
        return stringBuilder.toString();
    }

    private void addBallMessage(StringBuilder stringBuilder) {
        if (ball > INITIAL_COUNT) {
            String message = String.format(BALL_MESSAGE_FORMAT, ball);
            stringBuilder.append(message);
        }
    }

    private void addSpaceBetween(StringBuilder stringBuilder) {
        if (ball > INITIAL_COUNT && strike > INITIAL_COUNT) {
            stringBuilder.append(" ");
        }
    }

    private void addStrikeMessage(StringBuilder stringBuilder) {
        if (strike > INITIAL_COUNT) {
            String message = String.format(STRIKE_MESSAGE_FORMAT, strike);
            stringBuilder.append(message);
        }
    }
}
