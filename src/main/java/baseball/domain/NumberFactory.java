package baseball.domain;

import static baseball.domain.Number.NUMBER_SIZE;
import static baseball.domain.Number.START_NUMBER;
import static baseball.domain.Number.END_NUMBER;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberFactory {
	public static List<Integer> createRandomNumbers() {
		List<Integer> randomNumbers = new ArrayList<>();

		while (randomNumbers.size()<NUMBER_SIZE) {
			Integer randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
			if (!randomNumbers.contains(randomNumber)) {
				randomNumbers.add(randomNumber);
			}
		}
		return randomNumbers;
	}
}
