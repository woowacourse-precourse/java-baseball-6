package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static final int NEW_GAME_CODE = 1;
    public static final int END_GAME_CODE = 2;
    private static final int MIN_NUMERIC_RANGE_VALUE = 1;
    private static final int MAX_NUMERIC_RANGE_VALUE = 9;
    private static final int INPUT_LENGTH = 3;

    public String inputNumber() {
        String input = readLine();
        validateInput(input);
        return input;
    }

    private void validateInput(String input) {
        isNumeric(input);
        isTripleDigit(input);
        isValidDigitRange(input);
        hasNoDuplicates(input);
    }

    private void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    private void isTripleDigit(String input) {
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException("세 자리의 입력값이 아닙니다.");
        }
    }

    private void isValidDigitRange(String input) {
        for (char eachChar : input.toCharArray()) {
            int eachDigit = Character.getNumericValue(eachChar);
            if (eachDigit < MIN_NUMERIC_RANGE_VALUE || eachDigit > MAX_NUMERIC_RANGE_VALUE) {
                throw new IllegalArgumentException("1 에서 9 사이의 값이 아닙니다.");
            }
        }
    }

    private void hasNoDuplicates(String input) {
        char[] inputArray = input.toCharArray();
        if (inputArray[0] == inputArray[1] || inputArray[1] == inputArray[2] || inputArray[0] == inputArray[2]) {
            throw new IllegalArgumentException("중복된 값이 존재합니다.");
        }
    }

    public int askForNewGameOrEnd() {
        String input = readLine();
        validateNewGameOrEndInput(input);
        return Integer.parseInt(input);
    }

    private void validateNewGameOrEndInput(String input) {
        isNumeric(input);
        isValueOneOrTwo(input);
    }

    private void isValueOneOrTwo(String input) {
        if (Integer.parseInt(input) != NEW_GAME_CODE && Integer.parseInt(input) != END_GAME_CODE) {
            throw new IllegalArgumentException("1과 2중 입력해야 합니다.");
        }
    }
}
