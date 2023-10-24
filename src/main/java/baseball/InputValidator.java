package baseball;

public class InputValidator {
    public void isValidInput(String input) {
        if (!isInputThreeNumbers(input) || !isDuplicated(input) || !isDigitStringInRange(input)) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidChoice(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInputThreeNumbers(String input) {
        return input.length() == 3;
    }

    private boolean isDigitStringInRange(String input) {
        try {
            if (input.contains("0")) {
                return false;
            }
            Integer.parseInt(input);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean isDuplicated(String input) {
        boolean[] numberArray = new boolean[9];

        for(int index = 0; index < input.length(); index++) {
            int number = input.charAt(index)-'1';
            if (numberArray[number]) {
                return false;
            }
            numberArray[number] = true;
        }
        return true;
    }
}
