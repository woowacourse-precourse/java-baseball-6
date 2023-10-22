package baseball.utils;

import baseball.exception.NumbersInputException;

public class Util {

    public static void checkNumeric(String numbersString) throws IllegalArgumentException {
        boolean isNumeric = numbersString.chars().allMatch(Character::isDigit);

        if (isNumeric == false) {
            throw new IllegalArgumentException();
        }

    }
}
