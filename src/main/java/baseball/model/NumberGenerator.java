package baseball.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import baseball.util.Constant;

public class NumberGenerator {
	private final List<Integer> computerNumber = new ArrayList<>();

	public void generateNumber() {
		while (computerNumber.size() < Constant.NUMBER_LENGTH) {
			int randomNumber = Randoms.pickNumberInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER);
			if (!computerNumber.contains(randomNumber)) {
				computerNumber.add(randomNumber);
			}
		}
	}
}
