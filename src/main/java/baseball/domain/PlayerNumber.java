package baseball.domain;

import baseball.constant.BaseballConstant;
import baseball.messages.ValidationErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNumber {
    private List<Integer> playerNumbers = new ArrayList<>();

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public void updatePlayerNumbers(String playerNumbers) {
        validateNumbers(playerNumbers);
        this.playerNumbers = convertNumbers(playerNumbers);
    }
    private void validateNumbers(String numbers){
        checkDataType(numbers);
        checkLength(numbers);
        checkDuplicateDigit(numbers);
        checkExcludeZero(numbers);
    }

    private static void checkExcludeZero(String numbers) {
        if (numbers.contains("0")) {
            throw new IllegalArgumentException(ValidationErrorMessage.NUMBERS_INCLUDE_ZERO_ERROR);
        }
    }

    private static void checkDuplicateDigit(String numbers) {
        HashSet<Integer> sameDigitChecker = new HashSet<>();
        tempConverterToSet(numbers, sameDigitChecker);
        if (sameDigitChecker.size() < BaseballConstant.NUMBER_SIZE) {
            throw new IllegalArgumentException(ValidationErrorMessage.NUMBERS_SAME_DIGIT_ERROR);
        }
    }

    private static void tempConverterToSet(String numbers, HashSet<Integer> sameDigitChecker) {
        for (int i = 0; i < numbers.length(); i++) {
            char temp = numbers.charAt(i);
            int number = Character.getNumericValue(temp);
            sameDigitChecker.add(number);
        }
    }

    private static void checkLength(String numbers) {
        if (numbers.length() != BaseballConstant.NUMBER_SIZE) {
            throw new IllegalArgumentException(ValidationErrorMessage.NUMBERS_LENGTH_ERROR);
        }
    }

    private static void checkDataType(String numbers) {
        try {
            Arrays.asList(Integer.valueOf(numbers));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidationErrorMessage.NUMBERS_TYPE_ERROR);
        }
    }

    private static List<Integer> convertNumbers(String playerNumbers) {
        return Arrays.stream(playerNumbers.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


}
