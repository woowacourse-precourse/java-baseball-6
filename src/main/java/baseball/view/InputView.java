package baseball.view;

public class InputView {
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";

    public static void printInputRequestMessage() {
        System.out.print(INPUT_REQUEST_MESSAGE);
    }

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printRestartMessage() {
        System.out.println(RESTART_MESSAGE);
    }
}
