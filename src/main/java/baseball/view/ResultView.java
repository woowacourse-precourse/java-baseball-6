package baseball.view;

import baseball.service.CompareAnswerWithPlayerNumber;

public class ResultView {
    private final String NOTHING = "낫싱";

    public void outputCompareResult(CompareAnswerWithPlayerNumber compareAnswerWithPlayerNumber) {
        int strike = compareAnswerWithPlayerNumber.getStrike();
        int ball = compareAnswerWithPlayerNumber.getBall();

        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING);
        } else if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        } else if (strike > 0 && ball > 0) {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        }
    }
}
