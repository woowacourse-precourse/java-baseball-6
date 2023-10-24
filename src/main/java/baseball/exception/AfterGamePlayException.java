package baseball.exception;

public class AfterGamePlayException {
    private static final String PERMIT_NUMBER_REGEX = "[1-2]+";
    private static final int PERMIT_NUMBER_LENGTH = 1;

    public void askAfterResultException(String numberTypeOfString) {
        isRightLength(numberTypeOfString);
        isRightNumber(numberTypeOfString);
    }

    public void isRightLength(String numberTypeOfString) {
        if (!isUserInputLengthPermitted(numberTypeOfString)) {
            throw new IllegalArgumentException("하나의 숫자만 입력하셔야 합니다.");
        }
    }

    public void isRightNumber(String numberOfString) {
        if (!isUserInputContainsOnlyPermittedNumbers(numberOfString)) {
            throw new IllegalArgumentException("1~2 까지의 숫자만 입력하셔야합니다.");
        }
    }

    public boolean isUserInputLengthPermitted(String numberTypeOfString) {
        if (numberTypeOfString.length() != PERMIT_NUMBER_LENGTH) {
            return false;
        }
        return true;
    }

    public boolean isUserInputContainsOnlyPermittedNumbers(String numberTypeOfString) {
        if (!numberTypeOfString.matches(PERMIT_NUMBER_REGEX)) {
            return false;
        }
        return true;
    }
}