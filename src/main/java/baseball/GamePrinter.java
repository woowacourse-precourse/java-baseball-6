package baseball;

public class GamePrinter {

    public static void printStrikeAndBallCount(int strikeCount, int ballCount) {
        System.out.printf("%d볼 %d스트라이크", ballCount, strikeCount);
    }

    public static void printStrikeCount(int strikeCount) {
        System.out.printf("%d스트라이크", strikeCount);
    }

    public static void printBallCount(int ballCount) {
        System.out.printf("%d볼", ballCount);
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printGameStartMsg() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printGameOverMsg() {
        System.out.println("게임 종료");
    }
}
