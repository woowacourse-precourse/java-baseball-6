package baseball.view;

import baseball.domain.BaseballScore;

public class BaseballPrint extends BaseballScore {

    public BaseballPrint(int ballCount, int strikeCount) {
        super(ballCount, strikeCount);
    }

    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다");
    }

    public static void printInputNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printBallAndStrikeCount(int ballCount, int strikeCount) {
        if (ballCount > 0) {
            System.out.print(ballCount + "볼");
            if (strikeCount > 0) {
                System.out.print(" ");
            }
        }
        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크");
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }
}
