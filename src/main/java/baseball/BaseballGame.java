package baseball;

import java.util.ArrayList;
import java.util.List;

import baseball.domain.GameResult;
import baseball.ui.InputView;
import baseball.ui.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
	private final OutputView outputView;
	private final InputView inputView;

	private static List<Integer> computer;
	private static List<Integer> user;

	public BaseballGame(OutputView outputView, InputView inputView) {
		this.outputView = outputView;
		this.inputView = inputView;
	}

	public void start() {
		printStartMessage();
		computer = generateComputerNumber();

		while (true) {
			user = inputView.readNumber();
			GameResult result = play(computer, user);

			if (result.getStrikeCount() == 3) {
				outputView.printGameFinishMessage();
				String option = inputView.readRestartOrNot();
				if (option.equals("1")) {
					computer = generateComputerNumber();
					continue;
				} else if (option.equals("2")) {
					break;
				}
			}
			outputView.printGameResultMessage(result);
		}

	}

	private GameResult play(List<Integer> computer, List<Integer> user) {
		int strikeCount = 0;
		int ballCount = 0;

		for (int i = 0; i < 3; i++) {
			int userNumber = user.get(i);
			int computerNumber = computer.get(i);

			if (userNumber == computerNumber) {
				strikeCount++;
				continue;
			}
			if (computer.contains(userNumber)) {
				ballCount++;
			}
		}

		return new GameResult(strikeCount, ballCount);
	}

	private List<Integer> generateComputerNumber() {
		List<Integer> computer = new ArrayList<>();
		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}

		return computer;
	}

	private void printStartMessage() {
		outputView.printGameStartMessage();
	}
}
