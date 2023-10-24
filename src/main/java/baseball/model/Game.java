package baseball.model;

import baseball.view.UserNumbers;

public class Game {


    private final ComputerNumbers computerNumbers;
    private final UserNumbers userNumbers;

    public Game(ComputerNumbers computerNumbers, UserNumbers userNumbers) {
        this.computerNumbers = computerNumbers;
        this.userNumbers = userNumbers;
    }


    public String play() {
        Strike strike = new Strike();
        Ball ball = new Ball();
        for (int i = 0; i < 3; i++) {
            int target = userNumbers.valueOfIndex(i);
            if (computerNumbers.isStrike(target, i)) {
                strike.increaseStrikeCount();
                continue;
            }
            if (computerNumbers.isBall(target, i)) {
                ball.increaseBallCount();
            }
        }

        return formatResult(strike, ball);
    }

    private String formatResult(Strike strike, Ball ball) {
        if (strike.isThreeStrike()) {
            return Constant.END_GAME;
        }
        if (strike.isZeroStrike() && ball.isZeroBall()) {
            return Constant.ZERO;
        }
        StringBuilder result = new StringBuilder();
        appendIfNotZero(result, ball.getComment());
        appendIfNotZero(result, strike.getComment());
        return result.toString().trim();
    }

    private void appendIfNotZero(StringBuilder result, String comment) {
        if (!comment.equals(Constant.ZERO_COUNT)) {
            result.append(comment).append(" ");
        }
    }
}
