package baseball.model;

import static baseball.util.Constants.BALL_LENGTH;
import static baseball.util.Constants.DEFAULT_VALUE;

public record UserComputerCompare(Computer computer, Player player, Result result) {

    public UserComputerCompare(Computer computer, Player player) {
        this(computer, player, Result.initialBallCount());
    }

    public static UserComputerCompare judge(Computer computer, Player player) {
        return new UserComputerCompare(computer, player);
    }

    public Result ResultgetBallCountJudgement() {
        Result result = Result.initialBallCount();
        for (int position = DEFAULT_VALUE; position < BALL_LENGTH; position++) {
            result.updateBallCount(getBallCount(position));
        }
        return result;
    }

    private BallCount getBallCount(int position) {
        return BallCount.decideBallCount(hasCommonNumber(position), isInSamePosition(position));
    }

    private boolean isInSamePosition(int position) {
        return computer.getNumberByPosition(position) == player.getNumberByPosition(position);
    }


    private boolean hasCommonNumber(int position) {
        return computer.hasCommonNumber(player.getNumberByPosition(position));
    }
}