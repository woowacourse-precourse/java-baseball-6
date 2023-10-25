package baseball.view;

import baseball.dto.PlayResult;

public class OutputView {

    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printPlayResult(PlayResult result) {
        printNothing(result.isNothing());
        printBall(result.ballCount(), result.strikeCount());
        printStrike(result.strikeCount(), result.ballCount());
        printBallAndStrike(result.ballCount(), result.strikeCount());
    }

    private static void printNothing(boolean isNothing) {
        if (isNothing) {
            System.out.println("낫싱");
        }
    }

    private static void printBall(int ballCount, int strikeCount) {
        if (ballCount > 0 && strikeCount == 0) {
            System.out.println(ballCount + "볼");
        }
    }

    private static void printStrike(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }
    }

    private static void printBallAndStrike(int ballCount, int strikeCount) {
        if (ballCount > 0 && strikeCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    public static void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
