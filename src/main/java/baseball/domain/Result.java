package baseball.domain;

import baseball.global.Const;

public class Result {
    private int ballCount;
    private int strikeCount;

    private Result(int ballCount, int strikeCount) {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public static Result createFrom(int ballCount, int strikeCount) {
        return new Result(ballCount, strikeCount);
    }

    public String processResult() {
        StringBuilder result = new StringBuilder();

        if (isNothing()) {
            result.append(ResultFormat.NOTHING);
        }
        if (ballCount != 0) {
            result.append(String.format(ResultFormat.COUNT, ballCount, ResultFormat.BALL));
        }
        if (strikeCount != 0) {
            result.append(String.format(ResultFormat.COUNT, strikeCount, ResultFormat.STRIKE));
        }
        return result.toString().strip();
    }

    private boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }

    public boolean isLose() {
        return strikeCount == Const.STRIKE_COUNT;
    }
}
