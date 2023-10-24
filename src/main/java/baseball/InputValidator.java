package baseball;

public class InputValidator {

    private static final int VALID_LENGTH = 3;

    public static boolean isValidInput(String input) {
        // 1. 숫자 3개인지 확인
        if (input.length() != VALID_LENGTH) {
            return false;
        }
        // 2. 1 부터 9인지 확인
        for (char ch : input.toCharArray()) {
            int number = Character.getNumericValue(ch);
            if (number < 1 || number > 9) {
                return false;
            }
        }
        return hasDistinctCharacters(input);
    }
    // 3. 서로 다른 숫자 갯수 확인 (3이어야 함) fail-fast 위해서 1번도 포함!!
    private static boolean hasDistinctCharacters(String input) {
        return input.chars().distinct().count() == VALID_LENGTH;
    }
}