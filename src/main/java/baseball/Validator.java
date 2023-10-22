package baseball;

public class Validator {
    public void validate(String input) {
        if (isEmptyValue(input)) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
        if (!isCorrectLength(input)) {
            throw new IllegalArgumentException("세 자리 이외의 값은 입력할 수 없습니다.");
        }
        if (!isNumberType(input)) {
            throw new IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.");
        }
    }

    private boolean isContainingZero(String input) {
        return input.contains("0");
    }

    private boolean isCorrectLength(String input) {
        return input.length() == 3;
    }

    private boolean isEmptyValue(String input) {
        return input.isBlank();
    }

    private boolean isNumberType(String input) {
        return input.matches("^[0-9]*$");
    }
}
