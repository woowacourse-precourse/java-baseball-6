package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Controller {
	public void run() {
		System.out.println("숫자 야구 게임을 시작합니다.");
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
	}
}
