package baseball;

public class Validator {

    // 입력 값이 유효한 값인지 확인한다

    public void validateUserInputNumber(String userInputNumber)
        throws IllegalArgumentException {
        if (userInputNumber.length() != Constants.NUMBER_SIZE) {
            throw new IllegalArgumentException("세자리 수를 입력해주세요.");
        }
        if (!ensureRange(userInputNumber, Constants.MIN_RANGE_NUM, Constants.MAX_RANGE_NUM)) {
            throw new IllegalArgumentException("1과 9 사이의 숫자를 입력해주세요.");
        }
        if (existsDuplicateNumber(userInputNumber)) {
            throw new IllegalArgumentException("중복이 없는 숫자를 입력해주세요.");
        }
    }

    public void validateRestartOrQuit(String restartOrQuit) {
        if (!ensureRange(restartOrQuit, Constants.RESTART, Constants.QUIT)) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }

    public boolean ensureRange(String userInputValue, int min, int max) {
        for (char digit : userInputValue.toCharArray()) {
            int numericValue = Character.getNumericValue(digit);
            if (numericValue < min || numericValue > max) {
                return false;
            }
        }
        return true;
    }

    public boolean existsDuplicateNumber(String userInputNumber) {
        for (char digit : userInputNumber.toCharArray()) {
            if (userInputNumber.chars().filter(c -> c == digit).count() != 1) {
                return true;
            }
        }
        return false;
    }

}
