package baseball;

public class Validator {
    public void validate(String input) {
        if (isEmptyValue(input)) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
    }

    private boolean isCorrectLength(String input) {
        return input.length() == 3;
    }

    private boolean isEmptyValue(String input) {
        return input.isBlank();
    }
}
