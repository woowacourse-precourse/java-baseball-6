package baseball.view;

import baseball.model.CountStrikeAndBall;

public class OutputView {
    private final int strike;
    private final int ball;

    public OutputView(CountStrikeAndBall countStrikeAndBall) {
        this.strike = countStrikeAndBall.strike;
        this.ball = countStrikeAndBall.ball;
    }

    public void printBallAndStrike() {
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }


}
