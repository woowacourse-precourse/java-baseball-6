package baseball.gameutil.converter;

import baseball.gameutil.validate.InputMod;
import baseball.gameutil.validate.ValidateInput;
import baseball.gameutil.validate.ValidateInputFactory;
import baseball.io.Input;
import java.util.List;

/**
 * 야구게임에 사용할 GameInputConverter를 구현한 클래스다.
 */
public class GameInputConverterBaseball implements GameInputConverter {

    private final Input input;

    /**
     * @param input 사용자의 입력을 받는 객체다.
     */
    public GameInputConverterBaseball(Input input) {
        this.input = input;
    }

    /**
     * 사용자의 입력을 받아서 정수 리스트로 변환한다.
     * @param mod 입력을 받는 모드
     * @return 사용자의 입력을 정수 리스트로 변환한 결과다.
     */
    @Override
    public List<Integer> convertBaseballInput(InputMod mod) {
        String checkedInput = getCleanInput(mod);

        return checkedInput.chars()
            .map(Character::getNumericValue)
            .boxed()
            .toList();
    }

    private String getCleanInput(InputMod mod) {
        ValidateInput validator = ValidateInputFactory.getValidateInput(mod);
        return validator.validate(input.getInput());
    }
}
