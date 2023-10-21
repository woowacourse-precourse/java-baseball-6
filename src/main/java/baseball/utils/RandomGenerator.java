package baseball.utils;

import static baseball.model.Constant.NUMBER_LENGTH;
import static baseball.model.Constant.RANGE_MAX_NUMBER;
import static baseball.model.Constant.RANGE_MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {

	public List<Integer> generateRandomNumbers() {
		List<Integer> randomNumbers = new ArrayList<>(NUMBER_LENGTH);
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			randomNumbers.add(generateUniqueRandomNumber(randomNumbers));
		}
		return randomNumbers;
	}


	private int generateUniqueRandomNumber(List<Integer> randomNumbers) {
		while (true) {
			int randomNumber = Randoms.pickNumberInRange(RANGE_MIN_NUMBER, RANGE_MAX_NUMBER);
			if (!isNumberUsed(randomNumbers, randomNumber)) {
				return randomNumber;
			}
		}
	}

	private boolean isNumberUsed(List<Integer> randomNumbers, int randomNumber) {
		for (int number : randomNumbers) {
			if (number == randomNumber) {
				return true;
			}
		}
		return false;
	}
}
