package baseball.io;

import baseball.model.CompareResult;

public class OutputHandler {

    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printCompareResult(CompareResult result) {
        Integer ball = result.getBall();
        Integer strike = result.getStrike();

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }

        if (ball > 0) {
            System.out.printf("%d볼 ", ball);
        }
        if (strike > 0) {
            System.out.printf("%d스트라이크", strike);
        }
        System.out.println();
    }
}
