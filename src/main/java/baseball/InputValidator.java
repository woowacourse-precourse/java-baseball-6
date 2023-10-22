package baseball;

public class InputValidator {
    private InputValidator() {}
    public static boolean isValidatedAnswer(int digit, String inputAnswer) {
        String regex = String.format("^([0-9]){%d}$", digit);
        return inputAnswer.matches(regex);
    }

}
