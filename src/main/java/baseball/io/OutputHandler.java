package baseball.io;

public class OutputHandler {

    private OutputHandler() {
    }

    public static void printMessage(final String message) {
        System.out.println(message);
    }

    public static void printGameStart() {
        printMessage("숫자 야구 게임을 시작합니다.");
    }

    public static void printGameEnd() {
        printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printRestartOrExit() {
        printMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
