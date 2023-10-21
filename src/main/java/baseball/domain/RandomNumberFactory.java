package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberFactory {

	private static final int MIN_NUMBER_RANGE = 1;
	private static final int MAX_NUMBER_RANGE = 9;
	private static final int MAX_NUMBER_SIZE = 3;

	public Computer generate() {
		List<Integer> computer = new ArrayList<>();
		while (computer.size() < MAX_NUMBER_SIZE) {
			generateNumber(computer);
		}
		return new Computer(computer);
	}

	private void generateNumber(List<Integer> computer) {
		int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
		addRandomNumber(computer, randomNumber);
	}

	private void addRandomNumber(List<Integer> computer, int randomNumber) {
		if (!computer.contains(randomNumber)) {
			computer.add(randomNumber);
		}
	}
}
