package baseball.controller;

import baseball.model.Calculator;
import baseball.model.ListNumber;
import baseball.model.NumberGenerator;
import baseball.model.Score;

public class BaseballManager {
	private ListNumber computerNumber;

	public void initComputerNumber() {
		computerNumber = new ListNumber(NumberGenerator.generateNumber());
	}

	public Score userScore(int number) {
		ListNumber userNumber = new ListNumber(number);
		return Calculator.calculateScore(userNumber, computerNumber);
	}
}
