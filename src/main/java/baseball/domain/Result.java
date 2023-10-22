package baseball.domain;

import baseball.domain.constants.NumberBaseballConstants;

public class Result {

    private final int ball;
    private final int strike;
    private final int numberLength;

    private Result(int ball, int strike, int numberLength) {
        this.ball = ball;
        this.strike = strike;
        this.numberLength = numberLength;
    }

    public static Result create(Answer answer, Answer guessAnswer) {
        if(answer.getSize() != guessAnswer.getSize()) throw new IllegalArgumentException("Result 인스턴스를 만들 수 없습니다.");

        int ballCount = 0;
        int strikeCount = 0;

        for(int i=0; i<guessAnswer.getAnswer().size(); i++) {
            int number = guessAnswer.getAnswer().get(i);
            int index = answer.getAnswer().indexOf(number);

            if(index == -1) continue;

            if(index == i) strikeCount++;
            else ballCount++;
        }

        return new Result(ballCount, strikeCount,answer.getSize());
    }


    public boolean isCorrect() {
        return ball == 0 && strike == numberLength;
    }

    @Override
    public String toString() {
        if(ball == 0 && strike == 0) return NumberBaseballConstants.NOTHING;

        String result = "";
        if(ball > 0) result = ball + NumberBaseballConstants.BALL + " ";
        if(strike > 0) result += strike + NumberBaseballConstants.STRIKE;

        return result.trim();
    }
}
