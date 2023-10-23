package baseball.domain.gamenumber;

public class GameNumbersValidator {
    private static final String VALID_NUMBER_LENGTH = String.format("^\\d{%d}$", GameNumbers.LENGTH);

    private GameNumbersValidator() {}

    static void validate(String gameNumbers) {
        validateNumberLength(gameNumbers);
        validateDuplication(gameNumbers);
    }

    private static void validateNumberLength(String gameNumbers) {
        if (!gameNumbers.matches(VALID_NUMBER_LENGTH)) {
            throw new IllegalArgumentException("Error : 게임 숫자는 3개의 수로 이루어져야 합니다.");
        }
    }

    private static void validateDuplication(String gameNumbers) {
        if (countDistinctNumbers(gameNumbers) != GameNumbers.LENGTH) {
            throw new IllegalArgumentException("게임 숫자의 각 자리수는 중복될 수 없습니다.");
        }
    }

    private static int countDistinctNumbers(String gameNumbers) {
        return (int) gameNumbers.chars()
                .distinct()
                .count();
    }
}
