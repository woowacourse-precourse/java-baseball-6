package baseball.output;

public class GameOutput {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_MESSAGE = "숫자를 입력해주세요 : ";

    public static void printRequestMessage() {
        System.out.print(REQUEST_MESSAGE);
    }

    public static void printlnStartMessage() {
        System.out.println(START_MESSAGE);
    }

}
