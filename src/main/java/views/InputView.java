package views;

import service.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private final Validator validator;
	private final OutputView outputView;
	public InputView(Validator validator, OutputView outputView) {
		this.validator = validator;
		this.outputView = outputView;
	}

	public int getInputNumber() {
		try {
			outputView.printInputMent();
			int inputNumber = Integer.parseInt(Console.readLine());
			if (!(validator.checkDigit(inputNumber) && validator.checkDuplication(inputNumber) && validator.checkNumber(inputNumber))) {
				throw new IllegalArgumentException();
			}
			return inputNumber;
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}

	}

	public String inputOpinion() {
		outputView.printOpinionMent();
		String opinion = Console.readLine();
		return opinion;
	}
}
