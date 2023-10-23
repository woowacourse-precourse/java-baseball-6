package baseball.gameutil.converter;

import baseball.gameutil.InputMod;
import baseball.gameutil.validate.ValidateInput;
import baseball.gameutil.validate.ValidateInputFactory;
import baseball.io.Input;
import java.util.List;

public class GameInputConverterBaseball implements GameInputConverter {

    private final Input input;

    public GameInputConverterBaseball(Input input) {
        this.input = input;
    }

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
