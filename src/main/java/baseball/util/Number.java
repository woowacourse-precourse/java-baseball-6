package baseball.util;

public class Number {
    /**
     * 숫자가 맞는지 검증한다.
     *
     * @param input 사용자에게 입력받은 데이터를 받는다.
     * @return 정수일 경우 true, 정수가 아닐 경우 false를 반환한다.
     */
    public static void validationNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
