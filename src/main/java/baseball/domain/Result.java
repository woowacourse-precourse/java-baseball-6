package baseball.domain;

import baseball.domain.constants.NumberBaseballConstants;

import java.util.List;

public class Result {

    private final int ball;
    private final int strike;

    private Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static Result of(List<Integer> answer, List<Integer> guessAnswer) {
        int ballCount = 0;
        int strikeCount = 0;

        for(int i=0; i<guessAnswer.size(); i++) {
            int number = guessAnswer.get(i);
            int index = answer.indexOf(number);

            if(index == -1) continue;

            if(index == i) strikeCount++;
            else ballCount++;
        }

        return new Result(ballCount, strikeCount);
    }

    @Override
    public String toString() {
        if(ball == 0 && strike == 0) return NumberBaseballConstants.NOTHING;

        String result = "";
        if(ball > 0) result = ball + NumberBaseballConstants.BALL + " ";
        if(strike > 0) result += strike + NumberBaseballConstants.STRIKE;

        return result.trim();
    }

    public boolean isCorrect() {
        return ball == 0 && strike == 3;
    }
}
