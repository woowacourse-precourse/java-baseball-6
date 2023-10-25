package baseball.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import baseball.model.Game;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerController {
	InputView inputView = new InputView();

	public List<Integer> getComputerNumber() {
		List<Integer> computer = new ArrayList<>();

		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
		return computer;
	}

	public Game getPlayerNumbers() {
		String playerInputNumber = inputView.enterGameNumber();

		Game playerGameData = new Game();
		List<Integer> playerNumbers = convertNumberStringToList(playerInputNumber);
		playerGameData.setGameNumbers(playerNumbers);

		return playerGameData;
	}

	private static List<Integer> convertNumberStringToList(String InputNumber) {
		return InputNumber.chars()
			.mapToObj(Character::getNumericValue)
			.collect(Collectors.toList());
	}

	public Game compareNumber(Game computerData, Game playerData) {
		int strikeCount = 0;
		int ballCount = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if ((computerData.getGameNumbers().get(i) == playerData.getGameNumbers().get(j)) && (i == j)) {
					strikeCount++;
				} else if ((computerData.getGameNumbers().get(i) == playerData.getGameNumbers().get(j)) && (i != j)) {
					ballCount++;
				}
			}
		}

		playerData.setStrikeCountAndBallCount(strikeCount, ballCount);

		return playerData;
	}
}
