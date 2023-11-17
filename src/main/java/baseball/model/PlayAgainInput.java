package baseball.model;

public class PlayAgainInput {
    private int value;

    public PlayAgainInput(String input) {
        int inputToIntValue = validateNumeric(input);
        validateInput(inputToIntValue);
        value = inputToIntValue;
    }

    private int validateNumeric(String input) {
        int intInputValue;
        try {
            intInputValue  = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2를 입력해주세요.");
        }
        return intInputValue;
    }

    private void validateInput(int input) {
        if ((input != 1) && (input != 2)) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2 를 입력해주세요.");
        }
    }

    public int getValue() {
        return value;
    }
}
