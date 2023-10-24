package baseball.output;

public class StartSceneOutput {
    private static final String STRING_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public StartSceneOutput() {
        // Empty
    }

    public void printStartMessage() {
        System.out.println(STRING_START_MESSAGE);
    }
}
