package baseball.view.input;

public class GameInputView {

    public static String readBallNumbers() {
        String input = InputViewUtils.readLine();
        return InputViewUtils.trimmedString(input);
    }

}
