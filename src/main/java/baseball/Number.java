package baseball;

import input.InputErrorMessage;

public class Number {

    private static final int NUMBER_LENGTH = 3;
    private static final String ZERO = "0";

    private final String number;

    private Number(String number) {
        validate(number);
        this.number = number;
    }

    public static Number of(String number) {
        return new Number(number);
    }

    public char get(int index) {
        return number.charAt(index);
    }

    public int length() {
        return NUMBER_LENGTH;
    }

    private void validate(String number) {
        if (number.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(InputErrorMessage.NUMBER);
        }
        if (!isNumeric(number)) {
            throw new IllegalArgumentException(InputErrorMessage.NUMBER);
        }
        if (number.contains(ZERO)) {
            throw new IllegalArgumentException(InputErrorMessage.NUMBER);
        }
        if (isDuplicate(number)) {
            throw new IllegalArgumentException(InputErrorMessage.NUMBER);
        }
    }

    private boolean isNumeric(String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicate(String number) {
        for (int i = 0; i < NUMBER_LENGTH - 1; i++) {
            for (int j = i + 1; j < NUMBER_LENGTH; j++) {
                if (number.charAt(i) == number.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
