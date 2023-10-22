package baseball.model.validator;

public class NumberValidation {

    public void validateNumber(String userNumber) {
        if (isNumber(userNumber)) {
            throw new IllegalArgumentException("숫자가 아니다");
        } else if (is3Digit(userNumber)) {
            throw new IllegalArgumentException("3자리가 아니다");
        } else if (isDuplicateNumber(userNumber)) {
            throw new IllegalArgumentException("각 자리에 중복된 숫자가 있다");
        }
    }
    private boolean isNumber(String input) {
        return !input.matches("[0-9]+");
    }

    private boolean is3Digit(String input) {
        return input.length() != 3;
    }

    private boolean isDuplicateNumber(String userNumber) {
        return userNumber.charAt(0) == userNumber.charAt(1) ||
                userNumber.charAt(0) == userNumber.charAt(2) ||
                userNumber.charAt(1) == userNumber.charAt(2);
    }
}
