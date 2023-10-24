package baseball.view;

import baseball.constant.NumberConstant;

public class OutputView {

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }


    public void printResult(int ball, int strike) {
        if (ball != 0 && strike != 0) {
            printBallNStrike(ball, strike);
        }
        if (ball == 0 && strike != 0) {
            printStrike(strike);
        }
        if (ball != 0 && strike == 0) {
            printBall(ball);
        }
        if (ball == 0 && strike == 0) {
            printNothing();
        }
    }

    public void printBallNStrike(int ball, int strike) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public void printBall(int ball) {
        System.out.println(ball + "볼");
    }

    public void printStrike(int strike) {
        System.out.println(strike + "스트라이크");

        if (strike == NumberConstant.SUCCESS_NUMBER) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public void printNothing() {
        System.out.println("낫싱");
    }


}
