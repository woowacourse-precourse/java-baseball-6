package baseball.model.numberstrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputNumberSelectionStrategy implements NumberSelectionStrategy {
    private static final int VALID_LENGTH = 3;
    private static final String ONLY_NUMBERS_FROM_ONE_TO_NINE_ALLOWED = "1 ~ 9 사이의 숫자만 입력이 가능합니다.";
    private static final String ONLY_NUMBERS_ALLOWED = "숫자만 입력이 가능합니다.";
    private static final String DUPLICATE_NUMBER_INPUT_NOT_ALLOWED = "중복 된 숫자는 입력할 수 없습니다.";
    private static final String ONLY_THREE_DIGITS_ALLOWED = "세 자리의 숫자만 입력이 가능합니다.";
    private final String guessNumber;

    public UserInputNumberSelectionStrategy(String guessNumber) {
        validateInputNumber(guessNumber);
        this.guessNumber = guessNumber;
    }

    private static void validateInputNumber(String guessNumber) {
        isDigits(guessNumber);
        isValidDigitLength(guessNumber);
        isUniqueDigits(guessNumber);
        isValidRange(guessNumber);
    }

    private static List<Integer> convertStringToIntegerList(String guessNumber) {
        ArrayList<Integer> numberList = new ArrayList<>();
        for (char number : guessNumber.toCharArray()) {
            numberList.add(Character.getNumericValue(number));
        }
        return Collections.unmodifiableList(numberList);
    }

    private static void isValidRange(String guessNumber) {
        for (char number : guessNumber.toCharArray()) {
            validateNumberNotZero(number);
        }
    }

    private static void validateNumberNotZero(char number) {
        if (number == '0') {
            throw new IllegalArgumentException(ONLY_NUMBERS_FROM_ONE_TO_NINE_ALLOWED);
        }
    }

    private static void isDigits(String guessNumber) {
        boolean containsNonDigit = guessNumber.chars()
                .anyMatch(c -> !Character.isDigit(c));
        if (containsNonDigit) {
            throw new IllegalArgumentException(ONLY_NUMBERS_ALLOWED);
        }
    }

    private static void isUniqueDigits(String guessNumber) {
        Set<Character> duplicateSet = createDuplicateSet(guessNumber);
        if (duplicateSet.size() != guessNumber.length()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_INPUT_NOT_ALLOWED);
        }
    }

    private static Set<Character> createDuplicateSet(String guessNumber) {
        Set<Character> duplicateSet = new HashSet<>();
        for (char number : guessNumber.toCharArray()) {
            duplicateSet.add(number);
        }
        return duplicateSet;
    }

    private static void isValidDigitLength(String guessNumber) {
        if (guessNumber.length() != VALID_LENGTH) {
            throw new IllegalArgumentException(ONLY_THREE_DIGITS_ALLOWED);
        }
    }

    @Override
    public List<Integer> createNumbers() {
        return convertStringToIntegerList(guessNumber);
    }
}
