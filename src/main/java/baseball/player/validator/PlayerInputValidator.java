package baseball.player.validator;

public enum PlayerInputValidator {
    VALIDATOR;

    public void validateInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
        if (!isNumber(input)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        if (isDuplicated(input)) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
        }
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isDuplicated(String input) {
        return input.chars().distinct().count() != 3;
    }
}
