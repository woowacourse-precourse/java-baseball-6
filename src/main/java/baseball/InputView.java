package baseball;

public class InputView {

    private static final String INPUT_MESSAGE = "입력하세요";
    private static InputView instance;

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }
}
