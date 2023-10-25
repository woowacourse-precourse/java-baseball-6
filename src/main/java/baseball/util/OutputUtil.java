package baseball.util;

import baseball.game.Hint;

public class OutputUtil {

    public static void printRestartOrClose() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printBallAndStrike(Hint hint) {
        System.out.println(hint.getBall() + "볼 " + hint.getStrike() + "스트라이크");
    }

    public static void printOnlyBall(int ball) {
        System.out.println(ball + "볼");
    }

    public static void printOnlyStrike(int strike) {
        System.out.println(strike + "스트라이크");
    }
}