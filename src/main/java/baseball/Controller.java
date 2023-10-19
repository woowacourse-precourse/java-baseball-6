package baseball;

import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	public void run() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		Computer computer = new Computer();
		List<Integer> player = new ArrayList<>();
//		do {
		List<Integer> trial = InputView.readBaseballNumber();
//		} while (computer.isMisMatch(player));
	}
}
