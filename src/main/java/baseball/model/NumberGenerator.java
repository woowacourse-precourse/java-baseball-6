package baseball.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import baseball.util.Constant;

public class NumberGenerator {
	public static int generateNumber() {
		List<Integer> computerNumber = new ArrayList<>();

		while (computerNumber.size() < Constant.NUMBER_LENGTH) {
			int randomNumber = Randoms.pickNumberInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER);
			if (!computerNumber.contains(randomNumber)) {
				computerNumber.add(randomNumber);
			}
		}

		int generatedNumber = 0;
		for (int number : computerNumber) {
			generatedNumber = generatedNumber * 10 + number;
		}

		return generatedNumber;
	}
}
