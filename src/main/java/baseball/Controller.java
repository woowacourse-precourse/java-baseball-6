package baseball;

import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	public void run() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		Computer computer = new Computer();
		List<Integer> trial;
		while (true) {
			trial = InputView.readBaseballNumber();
			List<Integer> result = computer.calculateResult(trial);
			if (result.get(2) == 3) {
				break;
			}
		}
	}
}
