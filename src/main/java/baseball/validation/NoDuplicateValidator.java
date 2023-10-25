package baseball.validation;

import java.util.HashSet;
import java.util.Set;

/**
 * 야구 게임 입력값 내 중복 숫자를 검증하는 클래스입니다.
 *
 * <p>이 클래스는 주어진 야구 게임의 입력값에 중복된 숫자가 포함되어 있는지 검사합니다.
 * 만약 중복된 숫자가 발견되면 유효하지 않다고 간주됩니다.</p>
 */
public class NoDuplicateValidator implements Validator<String> {

    /**
     * 주어진 입력 문자열에 중복된 숫자가 포함되어 있는지 검사합니다.
     *
     * <p>입력값 내에 중복된 숫자가 있을 경우, 예외를 발생시킵니다.</p>
     *
     * @param input 중복을 검증받을 문자열 입력
     * @throws IllegalArgumentException 입력값 내에 중복된 숫자가 있을 경우 발생합니다.
     */
    @Override
    public void validate(String input) {
        Set<Character> numberSet = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (!numberSet.add(ch)) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }
        }
    }
}
