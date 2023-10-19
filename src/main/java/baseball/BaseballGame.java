package baseball;

import java.util.ArrayList;
import java.util.List;

import baseball.ui.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {

	private final OutputView outputView;

	public BaseballGame(OutputView outputView) {
		this.outputView = outputView;
	}

	public void start() {
		printStartMessage();
		List<Integer> computer = generateComputerNumber();


	}

	private List<Integer> generateComputerNumber() {
		List<Integer> computer = new ArrayList<>();
		while(computer.size() < 3) {
			computer.add(Randoms.pickNumberInRange(1, 9));
		}

		return computer;
	}

	private void printStartMessage() {
		outputView.printGameStartMessage();
	}
}
