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

}
