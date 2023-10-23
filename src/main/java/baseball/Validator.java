package baseball;

public class Validator {
    /**
     *   - 아무 것도 입력하지 않는 경우 (null)
     *   - 입력의 길이가 3보다 크거나 작은 경우
     *   - 숫자가 아닌 값을 포함하는 경우
     *   - 같은 수를 여러개 포함하는 경우
     *   - 범위를 벗어난 수를 포함하는 경우 (숫자 중 0을 포함하는 경우)
     *   - 이 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.
     */
    public void validateUserInput(String userInput) throws IllegalArgumentException {
        if (isNull(userInput) || isLengthNotThree(userInput) ||
                containsNotNum(userInput) || containsDuplicateNum(userInput)) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }

    private boolean isNull(String userInput) {
        return userInput == null;
    }

    private boolean isLengthNotThree(String userInput) {
        return userInput.length() != Constants.ANS_LEN;
    }

    private boolean containsNotNum(String userInput) {
        for (char ch : userInput.toCharArray()) {
            if (!('1' <= ch && ch <= '9')) {
                return true;
            }
        }
        return false;
    }

    private boolean containsDuplicateNum(String userInput) {
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
