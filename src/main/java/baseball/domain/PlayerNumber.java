package baseball.domain;

import baseball.input.Input;
import baseball.validator.InputValidator;

public class PlayerNumber {
    private String number;

    public void setNumber() {
        String inputNumber = Input.inputString("숫자를 입력해주세요 : ");

        InputValidator.validatePlayerInput(inputNumber);

        this.number = inputNumber;
    }

    public String getNumber() {
        return this.number;
    }
}
