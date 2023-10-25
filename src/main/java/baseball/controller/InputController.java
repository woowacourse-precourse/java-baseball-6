package baseball.controller;

import baseball.validate.GameValidate;
import baseball.view.InputView;
import java.util.List;

public class InputController {

    public List<Integer> getPlayerGuessNumber() {
        List<Integer> givenNumbers = InputView.getPlayerGuessNumbers();
        GameValidate.gameGuessNumbersCheck(givenNumbers);
        return givenNumbers;
    }

    public Integer getPlayerRestartNumber() {
        Integer givenNumber = InputView.getPlayerRestartNumber();
        GameValidate.gameRestartNumberCheck(givenNumber);
        return givenNumber;
    }

}
