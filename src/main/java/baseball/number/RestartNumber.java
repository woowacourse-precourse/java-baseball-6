package baseball.number;

public class RestartNumber {
    private static final String TRUE = "1";
    private static final String FALSE = "2";

    private final boolean value;

    public RestartNumber(String restartNumber) {
        this.value = validateRestartNumber(restartNumber);
    }

    public boolean getValue() {
        return value;
    }

    private boolean validateRestartNumber(String restartNumber) {
        if (restartNumber.equals(TRUE)) {
            return true;
        } else if (restartNumber.equals(FALSE)) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
