package baseball;

import java.util.List;

public class OutputView {

    public void printResult(GameScore score) {
        List<Integer> result = score.getResult();
        int strike = result.get(0);
        int ball = result.get(1);

        if (strike > 0 && ball == 0) {
            printStrike(strike);
        } else if (strike == 0 && ball > 0) {
            printBall(ball);
        } else if (strike > 0 && ball > 0) {
            printStrikeAndBall(strike, ball);
        } else if (strike == 0 && ball == 0) {
            printNothing();
        }
    }

    private void printStrike(int strike) {
        System.out.println(strike + "스트라이크");
    }

    private void printBall(int ball) {
        System.out.println(ball + "볼");
    }

    private void printStrikeAndBall(int strike, int ball) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    private void printNothing() {
        System.out.println("낫싱");
    }

    public void roundEndMsg() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
