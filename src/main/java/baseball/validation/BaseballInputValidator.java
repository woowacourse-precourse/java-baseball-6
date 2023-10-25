package baseball.validation;

import java.util.Arrays;
import java.util.List;

/**
 * 야구 게임 입력에 대한 검증을 수행하는 클래스입니다.
 *
 * <p>이 클래스는 야구 게임에 필요한 여러 검증 조건을 수행하며, 각각의 검증 조건은 {@code Validator} 인터페이스를
 * 구현한 여러 구체적인 검증기를 통해 실행됩니다.</p>
 */
public class BaseballInputValidator {

    private final List<Validator<String>> validators;

    /**
     * {@code BaseballInputValidator}의 기본 생성자입니다.
     *
     * <p>기본적으로 길이, 숫자, 중복 여부에 대한 검증기를 포함하고 있습니다.</p>
     */
    public BaseballInputValidator() {
        this.validators = Arrays.asList(new LengthValidator(), new DigitsValidator(), new NoDuplicateValidator());
    }

    /**
     * 주어진 입력에 대해 여러 검증 조건을 수행합니다.
     *
     * <p>내부적으로는 {@code validators} 목록에 있는 각 검증기를 통해 입력을 검증합니다.</p>
     *
     * @param input 검증을 받을 문자열 입력
     * @throws IllegalArgumentException 검증에 실패한 경우 발생합니다.
     */
    public void validate(String input) {
        for (Validator<String> validator : validators) {
            validator.validate(input);
        }
    }
}
