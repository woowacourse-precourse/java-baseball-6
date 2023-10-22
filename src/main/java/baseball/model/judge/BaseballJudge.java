package baseball.model.judge;

import baseball.model.ball.Ball;

public class BaseballJudge {

    private final Ball computerBall;

    private BaseballJudge(Ball computerBall) {
        this.computerBall = computerBall;
    }

    public static BaseballJudge computerBallOf(Ball computerBall) {
        return new BaseballJudge(computerBall);
    }

    public JudgeResult judge(Ball playerBall) {
        if (isNothing(playerBall)) {
            return JudgeResult.createNothingResult();
        }

        return JudgeResult.createBallStrikeResult(
                new BallCount(judgeBallCount(playerBall)),
                new StrikeCount(judgeStrikeCount(playerBall))
        );
    }

    private boolean isNothing(Ball playerBall) {
        return playerBall.getNumbers()
                .stream()
                .noneMatch(this.computerBall::hasNumber);
    }

    private int judgeStrikeCount(Ball playerBall) {
        int strikeCount = 0;

        for (int placeNo = 0; placeNo < 3; placeNo++) {
            if (isStrikeCondition(placeNo, playerBall)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private int judgeBallCount(Ball playerBall) {
        int ballCount = 0;

        for (int placeNo = 0; placeNo < 3; placeNo++) {
            if (isBallCondition(playerBall, placeNo)) {
                ballCount++;
            }
        }

        return ballCount;
    }

    private boolean isStrikeCondition(int placeNo, Ball playerBall) {
        return computerBall.isNumberMatchExactlyInPlaceNo(placeNo, playerBall.getNumberOfPlace(placeNo));
    }

    private boolean isBallCondition(Ball playerBall, int placeNo) {
        return !isStrikeCondition(placeNo, playerBall) &&
                computerBall.hasNumber(playerBall.getNumberOfPlace(placeNo));
    }

    public boolean isPlayerWon(Ball playerBall) {
        return judge(playerBall).hasThreeStrikeCount();
    }

}
