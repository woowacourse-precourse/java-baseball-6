package baseball.validation;

/**
 * 야구 게임의 제어 입력값을 검증하는 클래스입니다.
 *
 * <p>이 클래스는 게임 재시작 혹은 종료 등의 제어를 위한 입력값이 유효한지 검사합니다.
 * 현재 지원하는 유효한 입력값은 "1"과 "2"입니다. 이 외의 값은 유효하지 않다고 간주됩니다.</p>
 */
public class GameControlValidator implements Validator<String> {

    /**
     * 주어진 입력 문자열이 게임 제어에 대한 유효한 입력값인지 검사합니다.
     *
     * <p>입력값이 "1" 또는 "2"가 아닌 경우, 예외를 발생시킵니다.</p>
     *
     * @param input 검증을 받을 문자열 입력
     * @throws IllegalArgumentException 입력값이 "1" 또는 "2"가 아닌 경우 발생합니다.
     */
    @Override
    public void validate(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("유효한 입력이 아닙니다.");
        }
    }
}
