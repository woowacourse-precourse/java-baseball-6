package baseball.domain.score;

import baseball.domain.BaseballGame;
import java.util.StringJoiner;

public class ImmutableBallStrikeCount {

    private static final String NOTHING = "낫싱\n";
    private static final String BALL_FORMAT = "%d볼";
    private static final String STRIKE_FORMAT = "%d스트라이크";
    private static final String DELIMITER = " ";

    private final int ball;
    private final int strike;

    private ImmutableBallStrikeCount(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static ImmutableBallStrikeCount of(int ball, int strike) {
        return new ImmutableBallStrikeCount(ball, strike);
    }

    public boolean isAllStrike() {
        return strike == BaseballGame.BALL_COUNT;
    }

    public String toFormattedResult() {
        if (hasNoBall() && hasNoStrike()) {
            return NOTHING;
        }
        StringJoiner resultMaker = new StringJoiner(DELIMITER);
        addBallIfExist(resultMaker);
        addStrikeIfExist(resultMaker);

        return resultMaker + "\n";
    }

    private void addBallIfExist(StringJoiner result) {
        if (!hasNoBall()) {
            result.add(String.format(BALL_FORMAT, ball));
        }
    }

    private void addStrikeIfExist(StringJoiner result) {
        if (!hasNoStrike()) {
            result.add(String.format(STRIKE_FORMAT, strike));
        }
    }

    private boolean hasNoBall() {
        return ball == 0;
    }

    private boolean hasNoStrike() {
        return strike == 0;
    }
}
