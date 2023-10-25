package baseball.ui.input.validator;

public interface InputValidator {
    String validateInput(String input);

    default int changeValidateInputToInt(String input) {
        return Integer.parseInt(validateInput(input));
    }

    default void checkSizeValid(String input, int digit) {
        checkNull(input);
        if (input.length() != digit) {
            throw new IllegalArgumentException(String.format("입력은 %d 자리여야 합니다.", digit));
        }
    }

    default boolean isNumeric(String input) {
        checkNull(input);
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력은 null일 수 업습니다.");
        }
    }
}
