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
			Map<String, Integer> gameResult = play(computer);

			int ballCount = gameResult.get("볼");
			int strikeCount = gameResult.get("스트라이크");

			if(strikeCount == 3) {
				outputView.printGameFinishMessage();
				// TODO: 재시작 여부 입력받기 기능
				continue;
			}
			outputView.printGameResultMessage(ballCount, strikeCount);

		}

	}

	private Map<String, Integer> play(List<Integer> computer) {
		Map<String, Integer> gameResult = initGameResult();
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

		return gameResult;
	}

	private Map<String, Integer> initGameResult() {
		Map<String, Integer> gameResult = new HashMap<>();
		gameResult.put("볼", 0);
		gameResult.put("스트라이크", 0);

		return gameResult;
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
