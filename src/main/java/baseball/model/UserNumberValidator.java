package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class UserNumberValidator {
    public static void validateUserNumber(String userNumber, int numberSize) {
        checkIsDigit(userNumber);
        checkNumberSize(userNumber, numberSize);
        checkNotDuplicate(userNumber);
    }

    /**
     * 숫자가 아닐 경우 예외 발생
     */
    private static void checkIsDigit(String inputWord) {
        if (!inputWord.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    /**
     * 자리수가 맞지 않을 경우 예외 발생
     */
    private static void checkNumberSize(String inputWord, int numberSize) {
        if (inputWord.length() != numberSize) {
            throw new IllegalArgumentException("세자리 숫자가 아닙니다.");
        }
    }

    /**
     * 중복된 숫자가 있을 경우 예외 발생
     */
    private static void checkNotDuplicate(String inputWord) {
        Set<Character> inputWordSet = new HashSet<>();
        for (char c : inputWord.toCharArray()) {
            if (!inputWordSet.add(c)) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }
        }
    }
}