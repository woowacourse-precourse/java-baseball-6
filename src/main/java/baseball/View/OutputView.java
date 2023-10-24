package baseball.View;

public class OutputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static void printEnd() {
        System.out.println(END_MESSAGE);
    }

    public static void printGameResult(int strikeCount, int ballCount) {
        if (hasBothStrikeAndBall(strikeCount, ballCount)) {
            printBothStrikeAndBall(ballCount, strikeCount);
        } else if (hasStrikeOnly(strikeCount)) {
            printStrikeOnly(strikeCount);
        } else if (hasBallOnly(ballCount)) {
            printBallOnly(ballCount);
        } else {
            printNothing();
        }
    }

    private static boolean hasBothStrikeAndBall(int strikeCount, int ballCount) {
        return strikeCount > 0 && ballCount > 0;
    }

    private static boolean hasStrikeOnly(int strikeCount) {
        return strikeCount > 0;
    }

    private static boolean hasBallOnly(int ballCount) {
        return ballCount > 0;
    }

    private static void printBothStrikeAndBall(int ballCount, int strikeCount) {
        System.out.println(ballCount + "볼" + " " + strikeCount + "스트라이크");
    }

    private static void printStrikeOnly(int strikeCount) {
        System.out.println(strikeCount + "스트라이크");
    }

    private static void printBallOnly(int ballCount) {
        System.out.println(ballCount + "볼");
    }

    private static void printNothing() {
        System.out.println("낫싱");
    }

}
