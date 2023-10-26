package baseball.model;

import static baseball.util.Constants.BALL_LENGTH;
import static baseball.util.Constants.DEFAULT_VALUE;

public record Compare(Computer computer, Player player, Result result) {

    public Compare(Computer computer, Player player) {
        this(computer, player, Result.initialBallCount());
    }

    public static Compare judge(Computer computer, Player player) {
        return new Compare(computer, player);
    }

    public Result ResultgetBallCountJudgement() {
        return getBallCountJudgementFromPosition(Result.initialBallCount(), DEFAULT_VALUE);
    }

    private Result getBallCountJudgementFromPosition(Result result, int position) {
        if (position == BALL_LENGTH) {
            return result;
        }

        result.updateBallCount(getBallCount(position));
        return getBallCountJudgementFromPosition(result, position + 1);
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