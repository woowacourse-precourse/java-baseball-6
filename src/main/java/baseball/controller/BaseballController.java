package baseball.controller;

import baseball.model.BaseballInformation;
import baseball.view.Input;
import baseball.view.Output;

public class BaseballController {

	private String answerNumber;
	private String inputNumber;
	public void playGame() {
		BaseballInformation baseballInformation = new BaseballInformation();
		answerNumber = baseballInformation.getAnswerNumber();
		//System.out.printf("answer : %s\n", answerNumber);
		while(answerNumber.equals(inputNumber) == false){
			Output.printInputNumMessage();
			inputNumber = Input.getNumber();
			baseballInformation.compareAndSetStrikeBallCount(inputNumber);

			Output.printResult(baseballInformation);
		}

	}
}
