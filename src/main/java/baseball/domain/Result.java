package baseball.domain;

import baseball.Enum.CorrectCase;

public class Result {
    private int strike = 0;
    private int ball = 0;

    public Result(int[] computer, char[] guess) {
        for (int i = 0; i < 3; i++) {
            int userNum = Character.getNumericValue(guess[i]);
            switch (checkUserNum(computer[userNum], i + 1)) {
                case STRIKE -> strike += 1;
                case BALL -> ball += 1;
            }
        }
    }

    private CorrectCase checkUserNum(int computerTargetPosition, int userAnswerPosition) {
        if (computerTargetPosition == userAnswerPosition) {
            return CorrectCase.STRIKE;
        }
        return computerTargetPosition != 0 ? CorrectCase.BALL : CorrectCase.MISS;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
