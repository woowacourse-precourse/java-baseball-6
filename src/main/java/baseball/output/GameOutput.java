package baseball.output;

public class GameOutput {

    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_MESSAGE = "숫자를 입력해주세요 : ";

    public static void printRequestMessage() {
        System.out.print(REQUEST_MESSAGE);
    }

    public static void printlnStartMessage() {
        System.out.println(START_MESSAGE);
    }
}
