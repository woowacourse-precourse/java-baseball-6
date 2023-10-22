package baseball;

public class TerminateNumber {
    private final String number;

    public TerminateNumber(String number) {
        if (isValidNumber(number)) {
            this.number = number;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidNumber(String number) {
        if (number == null || number.length() != 1) {
            return false;
        }

        if (number.equals("1") || number.equals("2")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isTerminate() {
        if (number.equals("2")) {
            return true;
        }
        return false;
    }
}
