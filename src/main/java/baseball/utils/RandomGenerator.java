package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

	private static final int NUMBER_LENGTH = 3;
	private static final int RANGE_MIN_NUMBER = 1;
	private static final int RANGE_MAX_NUMBER = 9;

	public int[] generateRandomNumbers() {
		int[] randomNumbers = new int[NUMBER_LENGTH];

		for(int i = 0; i < NUMBER_LENGTH; i++) {
			randomNumbers[i] = generateRandomNumber();
		}
		return randomNumbers;
	}

	private int generateRandomNumber() {
		return Randoms.pickNumberInRange(RANGE_MIN_NUMBER, RANGE_MAX_NUMBER);
	}
}
