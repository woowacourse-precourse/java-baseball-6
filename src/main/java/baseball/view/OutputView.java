package baseball.view;

public class OutputView {

    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printNothing() {
        System.out.print("낫싱");
    }

    public static void printBall(int ballCount) {
        System.out.print(ballCount + "볼 ");
    }

    public static void printStrike(int strikeCount) {
        System.out.print(strikeCount + "스트라이크");
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
