package baseball.view.input;

public class GameInputView {

    private GameInputView() {
    }

    public static String readBallNumbers() {
        String input = InputViewUtils.readLine();
        return InputViewUtils.trimmedString(input);
    }

}
