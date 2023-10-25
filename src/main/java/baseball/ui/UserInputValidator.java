package baseball.ui;

public class UserInputValidator {

    public String check(String input) {
        isValid(input, 3);
        return input;
    }

    private void isValid(String input, int x) {
        if (input == null || input.length() != x || !isNumeric(input)) {
            throw new IllegalArgumentException(String.format("입력은 %d 자리 수의 정수여야 합니다.", x));
        }
    }

    private boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int checkResume(String resumeInput) {
        isValid(resumeInput, 1);
        int parseInt = Integer.parseInt(resumeInput);
        if (parseInt == 1 || parseInt == 2) {
            return parseInt;
        }
        throw new IllegalArgumentException(String.format("입력은 1 혹은 2의 값이어야합니다. 입력하신 값 : %d", parseInt));
    }
}
