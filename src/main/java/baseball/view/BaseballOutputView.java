package baseball.view;

public class BaseballOutputView {
    private static final int COUNT_ZERO = 0;

    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다");
    }

    public static void printBallAndStrikeCount(int ballCount, int strikeCount) {
        if (ballCount > COUNT_ZERO) {
            System.out.print(ballCount + "볼");
            if (strikeCount > COUNT_ZERO) {
                System.out.print(" ");
            }
        }
        if (strikeCount > COUNT_ZERO) {
            System.out.print(strikeCount + "스트라이크");
        }
        if (ballCount == COUNT_ZERO && strikeCount == COUNT_ZERO) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
