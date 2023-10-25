package baseball.validation;

/**
 * 야구 게임의 입력값에 포함된 문자들이 숫자(1-9)인지를 검증하는 클래스입니다.
 *
 * <p>이 클래스는 입력 문자열의 각 문자가 숫자(1-9)에 해당하는지를 검사하며, 해당 범위에 속하지 않는 문자가 포함된 경우
 * 예외를 발생시킵니다.</p>
 */
public class DigitsValidator implements Validator<String> {

    /**
     * 주어진 입력 문자열의 각 문자가 숫자(1-9)에 해당하는지 검사합니다.
     *
     * <p>문자열 내에 숫자(1-9) 범위를 벗어난 문자가 포함되어 있다면 {@code IllegalArgumentException}을 발생시킵니다.</p>
     *
     * @param input 검증을 받을 문자열 입력
     * @throws IllegalArgumentException 숫자(1-9) 범위를 벗어난 문자가 포함된 경우 발생합니다.
     */
    @Override
    public void validate(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch) || ch == '0') {
                throw new IllegalArgumentException("입력된 숫자가 1~9 범위에 속하지 않습니다.");
            }
        }
    }
}
