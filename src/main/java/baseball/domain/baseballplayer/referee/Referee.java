package baseball.domain.baseballplayer.referee;

import baseball.domain.baseballplayer.team.BaseBallTeam;

public class Referee {
    private final Rule rule;
    private final int MIN_SIZE = 0;
    private int strikeCount = 0;
    private int ballCount = 0;

    private Referee(final Rule rule) {
        this.rule = rule;
    }

    public static Referee newInstance(final Rule rule) {
        return new Referee(rule);
    }

    public void printResult(final BaseBallTeam defenseTeam, final BaseBallTeam offenseTeam) {
        final StringBuilder result = new StringBuilder();

        rule.setTeamsBallNumbers(defenseTeam.getBall(), offenseTeam.getBall());
        ballCount = rule.calculateBallCount();
        strikeCount = rule.calculateStrikeCount();
        makeResult(result);

        System.out.println(result);
    }

    public boolean isRoundOver() {
        final int WIN_STRIKE_COUNT = 3;
        return strikeCount == WIN_STRIKE_COUNT;
    }

    private void makeResult(final StringBuilder result) {
        appendBallResult(result);
        appendStrikeResult(result);
        appendNothingResult(result);
    }

    private void appendBallResult(final StringBuilder result) {
        if (ballCount > MIN_SIZE) {
            final String BALL = "볼";
            result.append(ballCount).append(BALL).append(" ");
        }
    }

    private void appendStrikeResult(final StringBuilder result) {
        if (strikeCount > MIN_SIZE) {
            final String STRIKE = "스트라이크";
            result.append(strikeCount).append(STRIKE);
        }
    }

    private void appendNothingResult(final StringBuilder result) {
        if (strikeCount == MIN_SIZE && ballCount == MIN_SIZE) {
            final String NOTTING = "낫싱";
            result.append(NOTTING);
        }
    }

}
