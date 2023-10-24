package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import input.InputErrorMessage;

public class Number {

    protected static final int NUMBER_LENGTH = 3;
    private static final String OUT_OF_BOUND = "0";

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final String number;

    private Number(String number) {
        validate(number);
        this.number = number;
    }

    public static Number from(String number) {
        return new Number(number);
    }

    static Number getRandomNumber() {
        StringBuilder computer = new StringBuilder();
        while (computer.length() < NUMBER_LENGTH) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
            if (!computer.toString().contains(randomNumber)) {
                computer.append(randomNumber);
            }
        }
        return Number.from(computer.toString());
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
        if (number.contains(OUT_OF_BOUND)) {
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
