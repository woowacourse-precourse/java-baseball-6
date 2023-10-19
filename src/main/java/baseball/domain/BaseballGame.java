package baseball.domain;

import static baseball.global.constant.BaseballConstant.*;

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

		playGame();
	}

	private void playGame() {
		while (true) {
			user = inputView.readPlayerNumber();
			GameResult result = play(computer, user);

			if (result.getStrikeCount() == THREE_STRIKE) {
				outputView.printGameFinishMessage();
				String option = inputView.readRestartOrNot();
				if (option.equals(SIGN_RESTART)) {
					computer = generateComputerNumber();
					continue;
				} else if (option.equals(SIGN_STOP)) {
					break;
				}
			}
			outputView.printGameResultMessage(result);
		}
	}

	private GameResult play(List<Integer> computer, List<Integer> user) {
		int strikeCount = 0;
		int ballCount = 0;

		for (int i = 0; i < PLAY_AMOUNT; i++) {
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
		while (computer.size() < PLAY_AMOUNT) {
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
