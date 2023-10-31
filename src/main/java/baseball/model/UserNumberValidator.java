package baseball.model;

public class UserNumberValidator {
    public static void validateUserNumber(int numberSize, String userNumber) {
        checkIsDigit(userNumber);
        checkNumberSize(numberSize, userNumber);
        checkNotDuplicate(userNumber);
    }

    /**
     * 숫자가 아닐 경우 예외 발생
     */
    private static void checkIsDigit(String inputWord) {
        if (inputWord.chars().noneMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    /**
     * 자리수가 맞지 않을 경우 예외 발생
     */
    private static void checkNumberSize(int numberSize, String inputWord) {
        if (inputWord.length() != numberSize) {
            throw new IllegalArgumentException(numberSize + "자리 숫자가 아닙니다.");
        }
    }

    /**
     * 중복된 숫자가 있을 경우 예외 발생
     */
    private static void checkNotDuplicate(String inputWord) {
        if (inputWord.chars().distinct().count() != inputWord.length()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
}