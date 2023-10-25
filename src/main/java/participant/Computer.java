package participant;

import camp.nextstep.edu.missionutils.Randoms;
import game.GameHost;
import java.util.ArrayList;
import java.util.List;

public class Computer {

	private List<String> computerRandomNumbers;

	public Computer() {
		makeComputerNumbers();
	}

	public List<String> getComputerRandomNumbers() {
		return computerRandomNumbers;
	}

	public void makeComputerNumbers() {
		computerRandomNumbers = new ArrayList<>();

		while (computerRandomNumbers.size() < GameHost.MAX_NUMBER_COUNT) {
			deduplicate(computerRandomNumbers, Integer.toString(
					Randoms.pickNumberInRange(GameHost.START_INCLUSIVE, GameHost.END_INCLUSIVE)));
		}
	}

	public void deduplicate(List<String> inputNumberArray, String computerNumbers) {
		if (!inputNumberArray.contains(computerNumbers)) {
			inputNumberArray.add(computerNumbers);
		}
	}
}
