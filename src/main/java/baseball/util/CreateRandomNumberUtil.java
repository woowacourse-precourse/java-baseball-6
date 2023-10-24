package baseball.util;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CreateRandomNumberUtil {
	static final int NUMBER_LENGTH = 3;
	static final int START_NUM = 1;
	static final int END_NUM = 9;
	private int randomNumber;
	private List<Integer> computerNumber = new ArrayList<>();

	public List<Integer> createRandomNumber() {
		computerNumber.clear();
		while (computerNumber.size() < NUMBER_LENGTH) {
			randomNumber = Randoms.pickNumberInRange(START_NUM, END_NUM);
			addToList(computerNumber, randomNumber);
		}
		return computerNumber;
	}

	public void addToList(List<Integer> computerNumber, int number) {
		if (!computerNumber.contains(number)) {
			computerNumber.add(randomNumber);
		}
	}
}