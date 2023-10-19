package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			Map<String, Integer> gameResult = new HashMap<>();
			gameResult.put("볼", 0);
			gameResult.put("스트라이크", 0);

			List<Integer> user = inputView.readNumber();

			for(int i  = 0; i < 3; i++) {
				int userNumber = user.get(i);

				if (computer.contains(userNumber)) {
					if(computer.get(i) == userNumber) {
						gameResult.put("스트라이크", gameResult.get("스트라이크")+1);
						continue;
					}
					gameResult.put("볼", gameResult.get("볼")+1);
				}
			}
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
