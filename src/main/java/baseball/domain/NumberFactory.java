package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberFactory {
	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 9;

	public static List<Integer> createRandomNumbers(int size) {
		List<Integer> randomNumbers = new ArrayList<>();

		while (randomNumbers.size()<size) {
			Integer randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
			if (!randomNumbers.contains(randomNumber)) {
				randomNumbers.add(randomNumber);
			}
		}
		return randomNumbers;
	}
}
