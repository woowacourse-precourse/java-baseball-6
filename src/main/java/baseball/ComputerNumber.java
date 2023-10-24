package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumber {
	private static final int NUMBER_LENGTH = 3;
	private static final int MIN = 1;
	private static final int MAX = 9;

	public List<Integer> computerNumbers() {
		List<Integer> computer = new ArrayList<>();
		while (computer.size() < NUMBER_LENGTH) {
			int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
		return computer;
	}
}