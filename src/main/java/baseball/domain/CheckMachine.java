package baseball.domain;

import baseball.view.ResultView;

import java.util.List;

public class CheckMachine {
    private BallCount ballCount;

    public CheckMachine(BallCount ballCount) {
        this.ballCount = ballCount;
    }

    // 정답과 답변 비교 메서드
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

//    public String checkAnswer1(List<Integer> generatedAnswer, List<Integer> pickNumbers) {
//        for (int i = 0; i < GameRules.INPUT_LIMIT.getValue(); i++) {
//
//        }
//
//        for (int i = 0; i<GameRules.INPUT_LIMIT.getValue(); i++) {
//            if (ballCount.isStrike(generatedAnswer.get(i), pickNumbers.get(i))) {
//                ballCount.plusStrike();
//            } else if (ballCount.isBall(generatedAnswer, pickNumbers)) {
//                ballCount.plusBall();
//            }
//        }
//        String result = resultView.showBallCount(strike, ball);
//        return result;
//    }
}
