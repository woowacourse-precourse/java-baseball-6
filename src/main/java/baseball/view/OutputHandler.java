package baseball.view;

import baseball.domain.scoringnumbers.Balls;
import baseball.domain.scoringnumbers.Strikes;

public class OutputHandler {
    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printStrikesAndBalls(Strikes numberOfStrikes, Balls numberOfBalls) {
        printBalls(numberOfBalls);
        printStrikes(numberOfStrikes);
        System.out.println();
    }

    public static void printAllStrike() {
        System.out.println("3스트라이크\n"
                + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static void printBalls(Balls numberOfBalls) {
        if (!numberOfBalls.isZero()) {
            System.out.print(numberOfBalls.get() + "볼 ");
        }
    }

    private static void printStrikes(Strikes numberOfStrikes) {
        if (!numberOfStrikes.isZero()) {
            System.out.print(numberOfStrikes.get() + "스트라이크");
        }
    }
}
