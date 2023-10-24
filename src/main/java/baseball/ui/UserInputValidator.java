package baseball.ui;

public class UserInputValidator {

    public String check(String input) {
        if (input == null || input.length() != 3 || !isNumeric(input)) {
            throw new IllegalArgumentException("입력은 세 자리 수의 정수여야 합니다.");
        }
        return input;
    }

    private boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}
