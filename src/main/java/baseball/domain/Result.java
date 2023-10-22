package baseball.domain;

import baseball.domain.constants.NumberBaseballConstants;

public class Result {

    private final int ball;
    private final int strike;

    private Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static Result create(Answer answer, Answer guessAnswer) {
        int ballCount = 0;
        int strikeCount = 0;

        for(int i=0; i<guessAnswer.getAnswer().size(); i++) {
            int number = guessAnswer.getAnswer().get(i);
            int index = answer.getAnswer().indexOf(number);

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

    public void showResult(NumberBaseballIO numberBaseballIO) {
        numberBaseballIO.printResult(this);
    }
}
