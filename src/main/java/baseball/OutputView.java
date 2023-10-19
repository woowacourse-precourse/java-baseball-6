package baseball;

public class OutputView {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] ";
    private static OutputView instance;

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

}
