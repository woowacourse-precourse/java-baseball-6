package baseball.domain;

import java.util.List;

public class CheckMachine {
    private BallCount ballCount;

    public CheckMachine(BallCount ballCount) {
        this.ballCount = ballCount;
    }

    public BallCount checkAnswer(List<Integer> generatedAnswer, List<Integer> pickNumbers) {
        for (int i = 0; i < GameRules.INPUT_LIMIT.getValue(); i++) {
            count(generatedAnswer, pickNumbers.get(i), i);
        }
        return ballCount;
    }

    private void count(List<Integer> generatedAnswers, int submittedAnswer, int index) {
        if (generatedAnswers.get(index) == submittedAnswer) {
            ballCount.plusStrike();
            return;
        }
        if (generatedAnswers.contains(submittedAnswer)) {
            ballCount.plusBall();
        }
    }
}
