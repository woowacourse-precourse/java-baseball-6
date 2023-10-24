package baseball.output;

public class GameSceneOutput {
    private static final String STRING_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public GameSceneOutput() {
        // Empty
    }

    public void printInputMessage() {
        System.out.print(STRING_NUMBER_INPUT_MESSAGE);
    }
}
