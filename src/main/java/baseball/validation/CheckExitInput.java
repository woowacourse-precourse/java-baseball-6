package baseball.validation;

public class CheckExitInput {
    public static final String RESTART_OR_EXIT_EXCEPTION_MSG = "입력이 1 또는 2여야 합니다.";

    public void checkValidationOfExit(String in) throws IllegalArgumentException {
        if (!isOneOrTwo(in)) {
            throw new IllegalArgumentException(RESTART_OR_EXIT_EXCEPTION_MSG);
        }
    }

    private boolean isOneOrTwo(String in) {
        return in.equals("1") || in.equals("2");
    }
}
