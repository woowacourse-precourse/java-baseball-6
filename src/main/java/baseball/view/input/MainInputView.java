package baseball.view.input;

public class MainInputView {

    private MainInputView() {
    }

    public static boolean readShouldStartNewGame() {
        String input = InputViewUtils.readLine();
        String trimmededInput = InputViewUtils.trimmedString(input);

        return MainCommand.shouldStartNewGame(trimmededInput);
    }

}
