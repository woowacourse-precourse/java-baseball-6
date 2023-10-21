package baseball.domain;

import baseball.constant.BallConstant;
import baseball.constant.BallStatus;
import baseball.constant.OutputMessage;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class GameResult {

    private static final int DEFAULT = 0;
    private final Map<BallStatus, Integer> elements;

    public GameResult() {
        this.elements = new EnumMap<>(BallStatus.class);
        Arrays.stream(BallStatus.values())
                .forEach(value -> elements.put(value , DEFAULT));

    }

    public void increaseCount(BallStatus ballStatus) {
        elements.put(ballStatus, elements.get(ballStatus) + 1);
    }

    public String getResultScreen() {
        StringBuilder sb = new StringBuilder();
        if (isNothing()) {
            sb.append(OutputMessage.NOTHING.getMessage());
            return sb.toString();
        }
        appendBall(sb);
        appendStrike(sb);
        return sb.toString();
    }

    private boolean isNothing() {
        return elements.get(BallStatus.NOTHING) == BallConstant.BALL_LENGTH.getValue();
    }

    private void appendBall(StringBuilder sb) {
        if (elements.get(BallStatus.BALL) != DEFAULT) {
            sb.append(String.format(OutputMessage.BALL.getMessage(), elements.get(BallStatus.BALL)));
        }
    }

    private void appendStrike(StringBuilder sb) {
        if (elements.get(BallStatus.STRIKE) != DEFAULT) {
            sb.append(String.format(OutputMessage.STRIKE.getMessage(), elements.get(BallStatus.STRIKE)));
        }
    }
}
