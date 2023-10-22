package baseball.validation;

public class CheckExitInput {
    public void checkValidationOfExit(String in) {
        if (!isOneOrTwo(in)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOneOrTwo(String in) {
        return in.equals("1") || in.equals("2");
    }
}
