package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Controller {
	public void run() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		do {
			proceed();
		} while (InputView.readRestart() == 1);
	}

	private void proceed() {
		Computer computer = new Computer();
		List<Integer> trial;
		while (true) {
			trial = InputView.readBaseballNumber();
			List<Integer> result = computer.calculateResult(trial);
			OutputView.printResult(result);
			if (result.get(1) == 3) {
				break;
			}
		}
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
}
