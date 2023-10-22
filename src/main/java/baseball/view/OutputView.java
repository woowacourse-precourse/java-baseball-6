package baseball.view;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printHintMessage(String hint) {
        System.out.println(hint);
    }

}
