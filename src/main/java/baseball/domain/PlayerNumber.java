package baseball.domain;

import baseball.input.Input;
import baseball.validator.InputValidator;

import static baseball.constant.MessageConstant.*;

public class PlayerNumber extends Number {

    @Override
    public void setNumber() {
        String inputNumber = Input.inputString(PLAYER_INPUT_MESSAGE);

        InputValidator.validatePlayerInput(inputNumber);

        this.number = inputNumber;
    }
}
