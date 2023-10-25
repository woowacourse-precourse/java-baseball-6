package baseball;

public class TerminateNumber {
    private final String number;

    public TerminateNumber(String number) {
        if (isValidNumber(number)) {
            this.number = number;
        } else {
            throw new IllegalArgumentException(ErrorCode.INVALID_TERMINATE_NUMBER.getErrorMessage());
        }
    }

    private boolean isValidNumber(String number) {
        if (number == null || number.length() != 1) {
            return false;
        }

        if (number.equals(ExitCode.CONTINUE.getExitCode()) || number.equals(ExitCode.EXIT.getExitCode())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isTerminate() {
        if (number.equals(ExitCode.EXIT.getExitCode())) {
            return true;
        }
        return false;
    }
}
