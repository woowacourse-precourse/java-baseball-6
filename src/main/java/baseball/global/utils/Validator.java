package baseball.global.utils;

import static baseball.global.constant.ErrorMessage.DUPLICATION_ERROR_MESSAGE;
import static baseball.global.constant.ErrorMessage.FORMAT_ERROR_MESSAGE;
import static baseball.global.constant.ErrorMessage.LENGTH_ERROR_MESSAGE;
import static baseball.global.constant.ErrorMessage.OPTION_ERROR_MESSAGE;
import static baseball.global.constant.Game.SIZE;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Validator {

    public static void validatePlayerNumber(String[] inputNumbers) {
        validateLength(inputNumbers);
        validateDuplication(inputNumbers);
        validateFormat(inputNumbers);
    }

    private static void validateLength(String[] numbers) {
        if (numbers.length != SIZE) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private static void validateDuplication(String[] numbers) {
        int nonDuplicatedSize = Arrays.stream(numbers).collect(Collectors.toSet()).size();
        if (nonDuplicatedSize != SIZE) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    private static void validateFormat(String[] numbers) {
        for (String number : numbers) {
            int num = number.charAt(0) - '0';
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE);
            }
        }
    }

    public static void validateRestartStatus(String str) {
        int option = str.charAt(0) - '0';
        if (option != 1 && option != 2) {
            throw new IllegalArgumentException(OPTION_ERROR_MESSAGE);
        }
    }
}
