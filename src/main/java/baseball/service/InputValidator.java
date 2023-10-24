package baseball.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class InputValidator {

    public void numericCheck(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void lengthCheck(String input, int size) {
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    public void duplicateCheck(String input) {
        String[] numbers = input.split("");

        if (numbers.length != Arrays.stream(numbers).distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDigitCheck(String input, int startNum, int endNum) {
        String[] numbers = input.split("");

        for (String number : numbers) {
            if (Integer.parseInt(number) < startNum || Integer.parseInt(number) > endNum) {
                throw new IllegalArgumentException();
            }
        }
    }
}
