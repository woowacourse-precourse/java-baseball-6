package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {

	private static final int NUMBER_LENGTH = 3;
	private static final int RANGE_MIN_NUMBER = 1;
	private static final int RANGE_MAX_NUMBER = 9;

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
