package views;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private int inputNumber;
	public InputView() {
		this.inputNumber = createNumber();
	}

	public int createNumber() {
		int inputNumber = Integer.parseInt(Console.readLine());
		//검증 과정
		return inputNumber;
	}
}
