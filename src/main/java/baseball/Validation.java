package baseball;

import java.util.Arrays;

public class Validation implements Validate {

    private final static int EXPECTED_LENGTH = 3;
    private final static int EXPECTED_RETRY_LENGTH = 1;

    @Override
    public boolean combinedValidation(String input) {
        if (validateInputType(input) && validateInputLength(input, EXPECTED_LENGTH)
                && validationEachDifferentElement(input)) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    /**
     * false : 입력된 값에 숫자 외의 포함될 경우 && validate(0) 문자가 포함되어 있을 경우
     */
    @Override
    public boolean validateInputType(String input) {
        for (int i = 0; i < input.length(); i++) {
            char charAt = input.charAt(i);
            if (!(Character.isDigit(charAt) && validateEqualInput(charAt, '0'))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validateInputLength(String input, int expectedLength) {
        if (input.length() != expectedLength) {
            return false;
        }
        return true;
    }

    @Override
    public boolean validateEqualInput(char input, char validate) {
        if (input == validate) {
            return false;
        }
        return true;
    }

    @Override
    public boolean validationEachDifferentElement(String input) {
        int[] intArr = inputToArr(input);

        if (Arrays.stream(intArr).distinct().count() == EXPECTED_LENGTH) {
            return true;
        }
        return false;
    }

    private int[] inputToArr(String input) {
        int[] intArr = new int[EXPECTED_LENGTH];

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(input.substring(i, i + 1));
        }
        return intArr;
    }

    public boolean validationReplayInput(String input) {
        if (validateInputType(input) && validateInputLength(input, EXPECTED_RETRY_LENGTH)) {
            if (input.equals("1")) {
                return true;
            }

            if (input.equals("2")) {
                return true;
            }
        }
        return false;
    }
}