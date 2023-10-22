package baseball.view;

import baseball.domain.Count;

public class OutputView {
    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void result(Count count) {
        int ball = count.getBallCount();
        int strike = count.getStrikeCount();

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0 && strike > 0) {
            System.out.println(strike + "스트라이크");
        }
    }

    public static void answer() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
