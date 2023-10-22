package baseball.Exception;

public class ReplayOrQuitGameException {
    private static final String RE_NUMBER_REGEX = "[1-2]";
    private static final int RE_NUMBER_SIZE = 1;

    public void selectReplayOrQuitGameException(String numberCasesOfString) {
        notOneDigitNumberCase(numberCasesOfString); // 숫자의 개수 예외
        notRangeOfNumberCase(numberCasesOfString); // 숫자의 종류 예외
    }

    //숫자의 개수가 1개가 아닌 경우
    public void notOneDigitNumberCase(String numberCasesOfString) {
        if (numberCasesOfString.length() != RE_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자는 1개만 입력하셔야 합니다.");
        }
    }

    //숫자의 종류가 1,2가 아닌 경우
    public void notRangeOfNumberCase(String numberCasesOfString) {
        if (!numberCasesOfString.matches(RE_NUMBER_REGEX)) {
            throw new IllegalArgumentException("1,2의 수 중 하나만을 입력해야 합니다.");
        }
    }
}