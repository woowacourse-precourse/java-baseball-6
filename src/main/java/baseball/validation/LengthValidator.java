package baseball.validation;

/**
 * 야구 게임 입력값의 길이를 검증하는 클래스입니다.
 *
 * <p>이 클래스는 야구 게임의 입력값이 기대하는 길이와 일치하는지 검사합니다.
 * 현재 기대하는 입력값의 길이는 3입니다. 이외의 길이는 유효하지 않다고 간주됩니다.</p>
 */
public class LengthValidator implements Validator<String> {

    private static final int EXPECTED_INPUT_LENGTH = 3;

    /**
     * 주어진 입력 문자열의 길이가 유효한 길이인지 검사합니다.
     *
     * <p>입력값의 길이가 3이 아닌 경우, 예외를 발생시킵니다.</p>
     *
     * @param input 길이를 검증받을 문자열 입력
     * @throws IllegalArgumentException 입력값의 길이가 3이 아닌 경우 발생합니다.
     */
    @Override
    public void validate(String input) {
        if (input.length() != EXPECTED_INPUT_LENGTH) {
            throw new IllegalArgumentException("입력된 숫자의 개수가 " + EXPECTED_INPUT_LENGTH + "개가 아닙니다.");
        }
    }
}
