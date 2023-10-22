package baseball.domain;

import static baseball.constants.CommonConstants.MAX_NUMBER_RANGE;
import static baseball.constants.CommonConstants.MAX_NUMBER_SIZE;
import static baseball.constants.CommonConstants.MIN_NUMBER_RANGE;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberFactory {

	public BaseballNumber generate() {
		List<Integer> computer = new ArrayList<>();
		while (computer.size() < MAX_NUMBER_SIZE) {
			generateNumber(computer);
		}
		return new BaseballNumber(computer);
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
