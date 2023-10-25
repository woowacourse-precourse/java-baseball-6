package baseball.handler.io;

import java.util.Map;

public class OutputHandler {

    private OutputHandler() {
    }

    public static void startGame() {
        System.out.println("숫자 야구게임을 시작합니다.");
    }

    public static void correctAnswer() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void provideHint(Map<String, Integer> hint) {

        int ball = hint.get("ball");
        int strike = hint.get("strike");
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }

        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }

        System.out.println();
    }

}
