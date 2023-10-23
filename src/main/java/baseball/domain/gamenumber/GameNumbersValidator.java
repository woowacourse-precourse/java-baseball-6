package baseball.domain.gamenumber;

import java.util.regex.Pattern;

class GameNumbersValidator {
    private static final String VALID_NUMBER_LENGTH = String.format("^\\d{%d}$", GameNumbers.LENGTH);
    private static final Pattern NUMBER_LENGHT_PATTERN = Pattern.compile(VALID_NUMBER_LENGTH);
    private static final String NUMBER_LENGTH_EXCEPTION_MESSAGE =
            String.format("Error : 게임 숫자는 %d개의 수로 이루어져야 합니다.", GameNumbers.LENGTH);

    private GameNumbersValidator() {}

    static void validate(String gameNumbers) {
        validateNumberLength(gameNumbers);
        validateDuplication(gameNumbers);
    }

    private static void validateNumberLength(String gameNumbers) {
        if (!NUMBER_LENGHT_PATTERN.matcher(gameNumbers).matches()) {
            throw new IllegalArgumentException(NUMBER_LENGTH_EXCEPTION_MESSAGE);
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
