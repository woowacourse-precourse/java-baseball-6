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

    public static void printEndGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
