package baseball.controller;

import baseball.validate.NumbersValidate;
import baseball.view.InputView;
import java.util.List;

public class InputController {
    public List<Integer> getPlayerGuessNumber() {
        List<Integer> givenNumbers = InputView.getPlayerGuessNumbers();
        NumbersValidate.gameInputValidateCheck(givenNumbers);
        return givenNumbers;
    }

}
