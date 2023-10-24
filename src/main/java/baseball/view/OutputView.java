package baseball.view;

public class OutputView {
    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printSpace() {
        System.out.print(" ");
    }

    public static void printBallMessage() {
        System.out.print("볼");
    }

    public static void printStrikeMessage() {
        System.out.print("스트라이크");
    }

    public static void printNothingMessage() {
        System.out.print("낫싱");
    }

    public static void printCount(int count) {
        System.out.print(count);
    }

    public static void printEndLine() {
        System.out.println();
    }

    public static void printGameSetMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
