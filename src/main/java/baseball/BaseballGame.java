package baseball;

import java.util.ArrayList;
import java.util.List;

import baseball.ui.InputView;
import baseball.ui.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
	private final OutputView outputView;
	private final InputView inputView;

	private static boolean doGame = true;

	public BaseballGame(OutputView outputView, InputView inputView) {
		this.outputView = outputView;
		this.inputView = inputView;
	}

	public void start() {
		printStartMessage();
		List<Integer> computer = generateComputerNumber();

		while(doGame) {
			List<Integer> user = inputView.readNumber();
		}

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
