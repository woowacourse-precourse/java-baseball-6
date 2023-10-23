package others;

public class ExceptionHandling {
    private static final int numberOfNumbers = 3;

    private static void isNull(final String strNumber) {
        if (strNumber.isBlank()) {
            throw new IllegalArgumentException("문자열이 비어있거나 빈 공백으로 이뤄져 있습니다. 게임을 종료합니다.");
        }
    }

    private static void isThree(final String strNumber) {
        if (strNumber.length() != numberOfNumbers) {
            throw new IllegalArgumentException("3자리 수를 입력하셔야 합니다. 게임을 종료합니다.");
        }
    }

}
