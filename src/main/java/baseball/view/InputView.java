package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final int MIN_NUMERIC_RANGE_VALUE = 1;
    private static final int MAX_NUMERIC_RANGE_VALUE = 9;
    private static final int INPUT_LENGTH = 3;

    public int inputNumber() {
        String input = readLine();
        validateInput(input);
        return Integer.parseInt(input);
    }

    private void validateInput(String input) {
        isNumeric(input);
        isTripleDigit(input);
        isValidDigitRange(input);
        hasNoDuplicates(input);
    }

    private static void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }
    }

    private static void isTripleDigit(String input) {
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException("세 자리의 입력값이 아닙니다.");
        }
    }

    private static void isValidDigitRange(String input) {
        for (char eachChar : input.toCharArray()) {
            int eachDigit = Character.getNumericValue(eachChar);
            if (eachDigit < MIN_NUMERIC_RANGE_VALUE || eachDigit > MAX_NUMERIC_RANGE_VALUE) {
                throw new IllegalArgumentException("1 에서 9 사이의 값이 아닙니다");
            }
        }
    }

    private static void hasNoDuplicates(String input) {
        char[] inputArray = input.toCharArray();
        if (inputArray[0] == inputArray[1] || inputArray[1] == inputArray[2] || inputArray[0] == inputArray[2]) {
            throw new IllegalArgumentException("중복된 값이 존재합니다");
        }
    }
}
