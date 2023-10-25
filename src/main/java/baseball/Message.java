package baseball;

public class Message {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String END_MESSAGE = "게임을 종료합니다.";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다. 다시 입력해주세요.";

    public static void printStartMessage() { System.out.println(START_MESSAGE); }
    public static void printInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }
    public static void printRestartMessage() {
        System.out.println(RESTART_MESSAGE);
    }
    public static void printEndMessage() {
        System.out.println(END_MESSAGE);
    }
    public static void printWinMessage() {
        System.out.println(WIN_MESSAGE);
    }
    public static String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
