package baseball.model;

import baseball.view.UserNumbers;

public class Game {

    public static final String END_GAME = "3스트라이크";
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
            return END_GAME;
        }
        if (strike.isZeroStrike() && ball.isZeroBall()) {
            return "낫싱";
        }
        StringBuilder result = new StringBuilder();
        appendIfNotZero(result, ball.getComment());
        appendIfNotZero(result, strike.getComment());
        return result.toString().trim();
    }

    private void appendIfNotZero(StringBuilder result, String comment) {
        if (!comment.equals("zero")) {
            result.append(comment).append(" ");
        }
    }
}
