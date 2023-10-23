package others;

public class ExceptionHandling {
    private static void isNull(final String strNumber) {
        if (strNumber.isBlank()) {
            throw new IllegalArgumentException("문자열이 비어있거나 빈 공백으로 이뤄져 있습니다. 게임을 종료합니다.");
        }
    }
}
