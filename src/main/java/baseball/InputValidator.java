package baseball;

/**
 * 입력 데이터의 유효성을 검사하는 유틸리티 클래스입니다.
 */
public class InputValidator {

    /**
     * 숫자 입력의 유효성을 검사합니다.
     *
     * @param input 검사할 입력 문자열
     * @throws IllegalArgumentException 입력이 숫자가 아닌 경우, 길이가 올바르지 않은 경우, 중복된 숫자가 있는 경우, 범위를 벗어난 경우 예외를 던집니다.
     */
    public static void validateNumberInput(String input) {
        // 입력이 숫자가 아닌 경우 예외 처리
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(GameConstants.NOT_A_NUMBER);
        }

        // 입력 문자열의 길이가 올바르지 않은 경우 예외 처리
        if (input.length() != GameConstants.LIST_SIZE) {
            throw new IllegalArgumentException(GameConstants.NOT_VALID_LENGTH);
        }

        // 중복된 숫자가 있는 경우 예외 처리
        if (hasDuplicateNumbers(input)) {
            throw new IllegalArgumentException(GameConstants.DUPLICATE_NUMBER);
        }

        // 숫자가 정해진 범위를 벗어난 경우 예외 처리
        if (!isWithinRange(input)) {
            throw new IllegalArgumentException(GameConstants.OUT_OF_RANGE);
        }
    }

    //입력 문자열에서 중복된 숫자가 있는지 확인합니다.
    private static boolean hasDuplicateNumbers(String input) {
        return input.chars().distinct().count() != input.length();
    }

    //입력 문자열의 숫자들이 정해진 범위 내에 있는지 확인합니다.
    private static boolean isWithinRange(String input) {
        return input.chars().allMatch(ch -> ch >= 1 + '0' && ch <= 9 + '0');
    }

    /**
     * 선택지 입력의 유효성을 검사합니다.
     *
     * @param input 검사할 선택지 입력 문자열
     * @throws IllegalArgumentException 선택지가 올바르지 않은 경우 예외를 던집니다.
     */
    public static void validateChoiceInput(String input) {
        // 입력이 숫자가 아닌 경우 예외 처리
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(GameConstants.NOT_A_NUMBER);
        }

        int choice = Integer.parseInt(input);

        // 선택지가 올바르지 않은 경우 예외 처리
        if (choice != GameConstants.RESTART_GAME && choice != GameConstants.END_GAME) {
            throw new IllegalArgumentException(GameConstants.NOT_A_VALID_CHOICE);
        }
    }
}
