package views;

import service.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private final Validator validator;
	public InputView(Validator validator) {
		this.validator = validator;
	}

	public int getInputNumber() {
		try {
			System.out.print("숫자를 입력해주세요 : ");
			int inputNumber = Integer.parseInt(Console.readLine());
			if (!(validator.checkDigit(inputNumber) && validator.checkDuplication(inputNumber))) {
				throw new IllegalArgumentException();
			}
			return inputNumber;
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}

	}
	public void printIntro() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	public String inputOpinion() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String opinion = Console.readLine();
		return opinion;
	}
}
