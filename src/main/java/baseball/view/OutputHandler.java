package baseball.view;

import baseball.domain.Result;

public class OutputHandler {
    public static void theGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printStrikesAndBalls(Result forPrint) {
        printBalls(forPrint.numberOfBalls);
        printStrikes(forPrint.numberOfStrikes);
        System.out.println();
    }

    public static void printAllStrike() {
        System.out.println("3스트라이크\n"
                + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static void printBalls(int numberOfBalls) {
        if (numberOfBalls >= 1) {
            System.out.println(numberOfBalls + "볼 ");
        }
    }

    private static void printStrikes(int numberOfStrikes) {
        if (numberOfStrikes >= 1) {
            System.out.print(numberOfStrikes + "스트라이크");
        }
    }
}
