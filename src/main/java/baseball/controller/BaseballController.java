package baseball.controller;

import baseball.model.BaseballInformation;
import baseball.validator.NumberValidator;
import baseball.view.Input;
import baseball.view.Output;

public class BaseballController {

	private String answerNumber;
	private String inputNumber;

	private BaseballInformation baseballInformation = new BaseballInformation();
	private NumberValidator numberValidator = new NumberValidator();

	public void playGame() {
		answerNumber = baseballInformation.getAnswerNumber();

		while(answerNumber.equals(inputNumber) == false){
			Output.printInputNumMessage();
			inputNumber = Input.getNumber();
			numberValidator.validateInputNumber(inputNumber, baseballInformation.getNumberCount());

			baseballInformation.compareAndSetStrikeBallCount(inputNumber);
			Output.printResult(baseballInformation);
		}

	}
}
