package baseball.view;

import java.util.List;

public class OutputView {

    private static final String startMessage = "숫자 야구 게임을 시작합니다.";
    private static final String endMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void displayStartMessage() {
        System.out.println(startMessage);
    }

    public void displayEndMessage() {
        System.out.println(endMessage);
    }

    public void displayResult(int strike, int ball) {
        if (isNothing(strike, ball)) {
            System.out.println("낫싱");
        } else if (isZero(strike)) {
            System.out.println(ball + "볼");
        } else if (isZero(ball)) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    private boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

    private boolean isZero(int count) {
        return count == 0;
    }
}
