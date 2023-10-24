package baseball.view;

public class FormValidation {
    public void isOnlyNumbers(String input) {
        String pattern = "^[1-9]*$";
        if (!input.matches(pattern)) {
            throw new IllegalArgumentException(ErrorConstants.NOT_ONLY_NUMBERS_ERROR);
        }
    }

    public void isOnlyThreeLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(ErrorConstants.NOT_ONLY_THREE_NUMBERS_ERROR);
        }
    }

    public void isOnlyOneOrTwo(String input) {
        if (input.equals("1") || input.equals("2")) {
            return;
        }
        throw new IllegalArgumentException(ErrorConstants.NOT_ONLY_ONE_OR_TWO_ERROR);
    }
}
