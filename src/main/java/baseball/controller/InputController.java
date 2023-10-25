package baseball.controller;

import baseball.validate.NumbersValidate;
import baseball.view.InputView;
import java.util.List;

public class InputController {

    public List<Integer> getPlayerGuessNumber() {
        List<Integer> givenNumbers = InputView.getPlayerGuessNumbers();
        NumbersValidate.gameGuessNumbersCheck(givenNumbers);
        return givenNumbers;
    }

    public Integer getPlayerRestartNumber() {
        Integer givenNumber = InputView.getPlayerRestartNumber();
        NumbersValidate.gameRestartNumberCheck(givenNumber);
        return givenNumber;
    }

}
