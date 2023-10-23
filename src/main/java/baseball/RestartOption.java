package baseball;

public class RestartOption {
    private static final String RESTART = "1";
    private static final String EXIT = "2";
    private final String restartOption;

    public RestartOption(String restartOption) {
        this.restartOption = restartOption;
        validateInput();
    }

    private void validateInput() {
        if (!restartOption.equals(RESTART) && !restartOption.equals(EXIT)) {
            throw new IllegalArgumentException(Message.INVALID_VALUE.getMessage());
        }
    }

    public boolean isRestart() {
        if (restartOption.equals(RESTART)) {
            return true;
        }
        return false;
    }


}
