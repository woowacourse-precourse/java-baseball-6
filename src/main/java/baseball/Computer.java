package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
	private final static int RANDOM_NUMBER_MINIMUM = 1;
	private final static int RANDOM_NUMBER_MAXIMUM = 9;
	private List<Integer> randomNumber = new ArrayList<>();

	public Computer() {
	}

	public void setRandomNumber() {
		while (randomNumber.size() < 3) {
			int number = Randoms.pickNumberInRange(RANDOM_NUMBER_MINIMUM, RANDOM_NUMBER_MAXIMUM);
			if (!randomNumber.contains(number)) {
				randomNumber.add(number);
			}
		}
	}

	public List<Integer> getRandomNumber() {
		return randomNumber;
	}
}
