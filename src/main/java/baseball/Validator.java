package baseball;

public class Validator {
    /**
     *   - 입력이 null인 경우
     *   - 입력의 길이가 3보다 크거나 작은 경우
     *   - 숫자가 아닌 값을 포함하는 경우
     *   - 같은 수를 여러개 포함하는 경우
     *   - 범위를 벗어난 수를 포함하는 경우 (숫자 중 0을 포함하는 경우)
     *   - 이 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.
     */
    public static void validateUserInput(String userInput) throws IllegalArgumentException {
        if (isNull(userInput) || !meetsLengthCondition(userInput, Constants.ANS_LEN) ||
                !meetsRangeCondition(userInput, '1', '9') || containsDuplicateNum(userInput)) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다. 애플리케이션을 종료합니다.");
        }
    }

    /**
     *   - 입력이 null인 경우
     *   - 입력의 길이가 1보다 크거나 작은 경우
     *   - 숫자가 아닌 값을 포함하는 경우
     *   - 이 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.
     */
    public static void validateRestartInput(String userInput) throws IllegalArgumentException {
        if (isNull(userInput) || !meetsLengthCondition(userInput, Constants.RESTART_LEN) ||
                !meetsRangeCondition(userInput, '1', '2')) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다. 애플리케이션을 종료합니다.");
        }
    }

    private static boolean isNull(String userInput) {
        return userInput == null;
    }

    private static boolean meetsLengthCondition(String userInput, int lengthLimit) {
        return userInput.length() == lengthLimit;
    }

    private static boolean meetsRangeCondition(String userInput, char start, char end) {
        for (char ch : userInput.toCharArray()) {
            if (!(start <= ch && ch <= end)) {
                return false;
            }
        }
        return true;
    }

    private static boolean containsDuplicateNum(String userInput) {
        int[] count = new int[10];
        for (char ch : userInput.toCharArray()) {
            int curCnt = ++count[ch - '0'];
            if (curCnt > 1) {
                return true;
            }
        }
        return false;
    }
}
