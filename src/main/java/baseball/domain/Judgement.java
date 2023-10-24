package baseball.domain;

import baseball.constant.JudgementMessage;

public class Judgement {
    private final int numOfBall;
    private final int numOfStrike;

    public Judgement(int numOfBall, int numOfStrike) {
        this.numOfBall = numOfBall;
        this.numOfStrike = numOfStrike;
    }

    public boolean isCorrectAnswer(int numberOfDigitsInAnswer) {
        return numOfStrike == numberOfDigitsInAnswer;
    }

    public void sayBallAndStrike(int numberOfDigitsInAnswer) {
        String message = String.format(JudgementMessage.BALL_AND_STRIKE.getMessage(), numOfBall, numOfStrike);
        if (numOfBall == 0 && numOfStrike == 0) {
            message = JudgementMessage.NOTHING.getMessage();
        } else if (numOfBall == 0 && numOfStrike > 0 && numOfStrike < numberOfDigitsInAnswer) {
            message = String.format(JudgementMessage.ONLY_STRIKE.getMessage(), numOfStrike);
        } else if (numOfBall > 0 && numOfStrike == 0) {
            message = String.format(JudgementMessage.ONLY_BALL.getMessage(), numOfBall);
        } else if (numOfBall == 0 && numOfStrike == numberOfDigitsInAnswer) {
            message = String.format(JudgementMessage.ONLY_STRIKE.getMessage(), numberOfDigitsInAnswer);
        }
        System.out.println(message);
    }
}
