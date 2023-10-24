package baseball.controller;

import baseball.model.GameInformation;
import baseball.validator.NumberValidator;
import baseball.view.Input;
import baseball.view.Output;

public class BaseballController {

    private GameInformation gameInformation = new GameInformation(3);
    private NumberValidator numberValidator = new NumberValidator();

    private String answerNumber;
    private String inputNumber;

    public void playGame() {
        gameInformation.initNumber();
        answerNumber = gameInformation.getAnswerNumber();

        while (answerNumber.equals(inputNumber) == false) {
            Output.printInputNumMessage();
            inputNumber = Input.getNumber();

            numberValidator.validateInputNumber(inputNumber, gameInformation.getNumberCount());

            gameInformation.compareAndSetStrikeBallCount(inputNumber);
            Output.printHint(gameInformation);
        }

    }
}
