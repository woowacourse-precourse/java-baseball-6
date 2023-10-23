package baseball;

public class Output {

    public static void printUserNumbersMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printRestartOrExitMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printHint(final GameResult gameResult) {
        System.out.println(gameResult.toString());
    }
}
