package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Controller {

	private Validator validator;

	public Controller(Validator validator) {
		this.validator = validator;
	}

	public void run() {
		OutputView.printMessage("숫자 야구 게임을 시작합니다.");
		do {
			proceed();
		} while (validator.validatedRestart(InputView.readRestart()) == 1);
	}

	private void proceed() {
		Computer computer = new Computer();
		List<Integer> trial;
		while (true) {
			trial = validator.validateBaseballNumber(InputView.readBaseballNumber());
			List<Integer> result = computer.calculateResult(trial);
			OutputView.printResult(result);
			if (result.get(1) == 3) {
				break;
			}
		}
		OutputView.printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
}
