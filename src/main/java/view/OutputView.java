package view;

public class OutputView {

    public static void printGameStartView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printBallCount(int value) {
        if (value == 0) {
            return;
        }
        System.out.println(value + "볼");
    }

    public static void printStrikeCount(int value) {
        if (value == 0) {
            return;
        }
        System.out.println(value + "스트라이크");
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

}
