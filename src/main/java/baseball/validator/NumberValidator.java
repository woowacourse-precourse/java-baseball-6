package baseball.validator;

public class NumberValidator {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    private NumberValidator() {
        throw new IllegalArgumentException("NumberValidator(): 인스턴스 생성 불가능");
    }

    public static void validateNaturalNumber(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("숫자는 " + MIN_VALUE + "에서 " + MAX_VALUE + "까지여야 합니다.");
        }
    }

    /**
     * (예외 처리) 1부터 9까지 숫자로 구성 (0 불가능)
     * (예외 처리) 입력 값은 3자리의 숫자 (양의 정수)
     * (예외 처리) 0 이하의 정수 불가능 (양의 정수니)
     * (예외 처리) 각 숫자는 중복 불가능 (겹칠 수 없음)
     */

}
