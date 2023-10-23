package baseball.gameutil;

import baseball.game.validate.ValidateInput;
import baseball.game.validate.ValidateInputFactory;
import baseball.io.Input;
import java.util.List;

public class GameInputConverterBaseball implements GameInputConverter {

    private final Input input;

    public GameInputConverterBaseball(Input input) {
        this.input = input;
    }

    @Override
    public List<Integer> convertBaseballInput(Integer mod) {
        String checkedInput = getCleanInput(mod);

        return checkedInput.chars()
            .map(Character::getNumericValue)
            .boxed()
            .toList();
    }

    private String getCleanInput(Integer mod) {
        ValidateInput validator = ValidateInputFactory.getValidateInput(mod);
        return validator.validate(input.getInput());
    }
}
